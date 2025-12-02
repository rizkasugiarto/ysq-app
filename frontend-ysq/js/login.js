// js/login.js

document.addEventListener("DOMContentLoaded", () => {
  console.log("login.js KELOAD");

  // ====== TOGGLE PASSWORD (mata buka/tutup) ======
  const passwordInput = document.getElementById("password");
  const togglePassword = document.getElementById("togglePassword");

  if (passwordInput && togglePassword) {
    togglePassword.addEventListener("click", function () {
      const type =
        passwordInput.getAttribute("type") === "password" ? "text" : "password";
      passwordInput.setAttribute("type", type);

      // ganti icon bx-hide <-> bx-show
      if (type === "text") {
        this.classList.remove("bx-hide");
        this.classList.add("bx-show");
      } else {
        this.classList.remove("bx-show");
        this.classList.add("bx-hide");
      }
    });
  }

  // ====== LOGIN KE BACKEND & REDIRECT ======
  const form = document.querySelector(".login-form");
  if (!form) {
    console.error("Form .login-form tidak ditemukan di login.html");
    return;
  }

  const submitBtn = form.querySelector("button[type='submit']");
  const defaultBtnText = submitBtn ? submitBtn.textContent : "Login";

  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    console.log("Form login disubmit");

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;

    if (!email || !password) {
      alert("Email dan password wajib diisi!!");
      return;
    }

    if (submitBtn) {
      submitBtn.disabled = true;
      submitBtn.textContent = "Memproses...";
    }

    try {
      const res = await fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });

      let data = {};
      try {
        data = await res.json();
      } catch {
        data = {};
      }

      console.log("RESPON LOGIN:", data);

      if (!res.ok) {
        alert(data.message || "Login gagal");
        return;
      }

      // normalisasi role: ADMIN, SANTRI, PENGAJAR atau ROLE_ADMIN
      let role = (data.role || "").toUpperCase();
      if (role.startsWith("ROLE_")) {
        role = role.substring(5); // buang "ROLE_"
      }

      try {
        localStorage.setItem("ysqUser", JSON.stringify({ email, role }));
        localStorage.setItem("role", role);
        localStorage.setItem("email", email);
      } catch (err) {
        console.warn("Gagal menyimpan ke localStorage:", err);
      }

      // Redirect berdasarkan role (PASTIKAN path & file ada)
      if (role === "ADMIN") {
        // misal file dashboard admin-mu: frontend-ysq/admin.html
        window.location.href = "admin.html";
      } else if (role === "SANTRI") {
        // misal: frontend-ysq/siswa/dashboardsiswa.html
        window.location.href = "siswa/dashboardsiswa.html";
      } else if (role === "PENGAJAR") {
        // misal: frontend-ysq/pengajar/DashboardPengajar.html
        window.location.href = "pengajar/DashboardPengajar.html";
      } else {
        alert("Role tidak dikenali: " + role);
      }
    } catch (err) {
      console.error(err);
      alert("Gagal terhubung ke server!");
    } finally {
      if (submitBtn) {
        submitBtn.disabled = false;
        submitBtn.textContent = defaultBtnText;
      }
    }
  });
});

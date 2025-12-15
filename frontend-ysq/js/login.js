// js/login.js

document.addEventListener("DOMContentLoaded", () => {
  console.log("login.js KELOAD");

  // ====== TOGGLE PASSWORD ======
  const passwordInput = document.getElementById("password");
  const togglePassword = document.getElementById("togglePassword");

  if (passwordInput && togglePassword) {
    togglePassword.addEventListener("click", function () {
      const type =
        passwordInput.getAttribute("type") === "password" ? "text" : "password";
      passwordInput.setAttribute("type", type);

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

  // GANTI kalau backend kamu beda:
  const API_LOGIN = "http://localhost:8080/api/auth/login";

  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    console.log("Form login disubmit");

    const emailEl = document.getElementById("email");
    const passEl = document.getElementById("password");

    const email = (emailEl?.value || "").trim();
    const password = passEl?.value || "";

    if (!email || !password) {
      alert("Email dan password wajib diisi!!");
      return;
    }

    if (submitBtn) {
      submitBtn.disabled = true;
      submitBtn.textContent = "Memproses...";
    }

    try {
      const res = await fetch(API_LOGIN, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });

      // coba parse json, kalau gagal ambil text
      let data = null;
      const contentType = res.headers.get("content-type") || "";
      if (contentType.includes("application/json")) {
        data = await res.json();
      } else {
        const text = await res.text();
        data = { message: text };
      }

      console.log("STATUS LOGIN:", res.status);
      console.log("RESPON LOGIN:", data);

      if (!res.ok) {
        alert(data?.message || `Login gagal (status ${res.status})`);
        return;
      }

      // normalisasi role: ADMIN/SANTRI/PENGAJAR atau ROLE_ADMIN
      let role = String(data?.role || "").toUpperCase();
      if (role.startsWith("ROLE_")) role = role.substring(5);

      // simpan (kalau mau simpan token juga, tinggal tambah)
      try {
        localStorage.setItem("ysqUser", JSON.stringify({ email, role }));
        localStorage.setItem("role", role);
        localStorage.setItem("email", email);

        // kalau backend mengirim token:
        if (data?.token) localStorage.setItem("token", data.token);
      } catch (err) {
        console.warn("Gagal menyimpan ke localStorage:", err);
      }

      // ✅ FIX PATH REDIRECT SESUAI STRUKTUR FOLDER KAMU
      if (role === "ADMIN") {
        // file kamu: frontend-ysq/admin/Admin.html
        window.location.href = "admin/Admin.html";
      } else if (role === "SANTRI") {
        // pastikan file ini memang ada
        window.location.href = "siswa/dashboardsiswa.html";
      } else if (role === "PENGAJAR") {
        // file kamu: frontend-ysq/pengajar/DashboardPengajar.html
        window.location.href = "pengajar/DashboardPengajar.html";
      } else {
        alert("Role tidak dikenali: " + role);
      }
    } catch (err) {
      console.error("FETCH ERROR:", err);
      alert("Gagal terhubung ke server! (cek CORS / backend 8080)");
    } finally {
      if (submitBtn) {
        submitBtn.disabled = false;
        submitBtn.textContent = defaultBtnText;
      }
    }
  });
});

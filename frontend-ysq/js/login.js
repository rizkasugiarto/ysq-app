document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector(".login-form");
  if (!form) return;

  const submitBtn = form.querySelector("button[type='submit']");
  const defaultBtnText = submitBtn ? submitBtn.textContent : "Login";

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;

    if (!email || !password) {
      alert("Email dan password wajib diisi!!");
      return;
    }

    // state loading
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

      console.log("RESPON LOGIN:", data); // debug di console

      if (!res.ok) {
        alert(data.message || "Login gagal");
        return;
      }

      // normalisasi role
      const role = (data.role || "").toUpperCase();

      // simpan info user (buat dipakai di dashboard)
      try {
        localStorage.setItem(
          "ysqUser",
          JSON.stringify({ email, role })
        );
        localStorage.setItem("role", role);
        localStorage.setItem("email", email);
      } catch (err) {
        console.warn("Gagal menyimpan ke localStorage:", err);
      }

      // Redirect berdasarkan role
      if (role === "ADMIN") {
        window.location.href = "admin/dashboard_admin.html";
      } else if (role === "SANTRI") {
        window.location.href = "siswa/dashboardsiswa.html";
      } else if (role === "PENGAJAR") {
        window.location.href = "pengajar/DashboardPengajar.html";
      } else {
        alert("Role tidak dikenali, hubungi admin.");
      }
    } catch (err) {
      console.error(err);
      alert("Gagal terhubung ke server!");
    } finally {
      // balikkan tombol ke normal
      if (submitBtn) {
        submitBtn.disabled = false;
        submitBtn.textContent = defaultBtnText;
      }
    }
  });
});

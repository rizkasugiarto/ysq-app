document.addEventListener("DOMContentLoaded", () => {
  const form = document.querySelector(".login-form");
  if (!form) return;

  const submitBtn = form.querySelector("button[type='submit']");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const email = document.getElementById("email").value.trim();
    const password = document.getElementById("password").value;

    if (!email || !password) {
      alert("Email dan password wajib diisi!!");
      return;
    }

    // optional: set state loading
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

      const data = await res.json();
      console.log("RESPON LOGIN:", data); // buat debug di console

      if (!res.ok) {
        alert(data.message || "Login gagal");
        return;
      }

      // simpan info user sederhana (buat dipakai di dashboard)
      try {
        localStorage.setItem(
          "ysqUser",
          JSON.stringify({ email, role: data.role })
        );
      } catch (err) {
        console.warn("Gagal menyimpan ke localStorage:", err);
      }

      // Normalisasi role ke huruf besar semua
      const role = (data.role || "").toUpperCase();

      // Redirect berdasarkan role
      if (role === "ADMIN") {
        window.location.href = "admin/dasboard_admin.html";
      } else if (role === "SANTRI") {
        window.location.href = "siswa/dashboardsiswa.html";
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
        submitBtn.textContent = "Login";
      }
    }
  });
});

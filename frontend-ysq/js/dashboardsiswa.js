// js/dashboardsiswa.js

document.addEventListener("DOMContentLoaded", () => {
    console.log("dashboardsiswa.js loaded");
  
    const email = localStorage.getItem("email");
    const role = localStorage.getItem("role");
  
    // Kalau belum login / bukan santri, tendang ke login
    if (!email || role !== "SANTRI") {
      alert("Silakan login sebagai santri terlebih dahulu.");
      window.location.href = "../login.html";
      return;
    }
  
    // Element yang mau diisi
    const nameEl = document.getElementById("student-name");
    const levelEl = document.getElementById("student-level");
    const scheduleEl = document.getElementById("student-schedule");
  
    // Tampilkan loading sementara
    if (nameEl) nameEl.textContent = "Memuat...";
    if (levelEl) levelEl.textContent = "-";
    if (scheduleEl) scheduleEl.textContent = "-";
  
    // Panggil backend: sesuaikan URL endpointnya
    fetch(
      "http://localhost:8080/api/santri/dashboard?email=" +
        encodeURIComponent(email)
    )
      .then((res) => {
        if (!res.ok) {
          throw new Error("HTTP " + res.status);
        }
        return res.json();
      })
      .then((data) => {
        console.log("DATA DASHBOARD SANTRI:", data);
  
        // Isi info dasar
        if (nameEl) nameEl.textContent = data.nama || "-";
        if (levelEl) levelEl.textContent = data.level || data.kelas || "-";
        if (scheduleEl)
          scheduleEl.textContent =
            data.jadwal || data.jadwalHari || "Jadwal belum diatur";
  
        // Kalau kamu punya elemen lain (no WA, kategori, dsb),
        // tinggal cari id-nya dan isi juga di sini.
      })
      .catch((err) => {
        console.error(err);
        alert("Gagal memuat data siswa dari server.");
        if (nameEl) nameEl.textContent = "-";
      });
  });
  
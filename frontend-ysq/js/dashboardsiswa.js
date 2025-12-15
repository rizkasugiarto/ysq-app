// frontend-ysq/js/dashboardsiswa.js

document.addEventListener("DOMContentLoaded", () => {
  console.log("dashboardsiswa.js loaded");

  const role = localStorage.getItem("role");
  const email = localStorage.getItem("email");

  const nameEl = document.getElementById("student-name");
  const levelEl = document.getElementById("student-level");
  const scheduleEl = document.getElementById("student-schedule");

  // default biar desain tampil
  if (nameEl) nameEl.textContent = "-";
  if (levelEl) levelEl.textContent = "-";
  if (scheduleEl) scheduleEl.textContent = "-";

  // kalau belum login, jangan redirect dulu (biar kamu bisa lihat desain)
  if (!email || !role || role !== "SANTRI") {
    console.warn("Belum login SANTRI. email/role:", email, role);
    if (nameEl) nameEl.textContent = "Belum login";
    return;
  }

  // sementara: tampilkan email (nanti baru kita sambung ke data santri by id)
  if (nameEl) nameEl.textContent = email;
  if (levelEl) levelEl.textContent = "-";
  if (scheduleEl) scheduleEl.textContent = "Jadwal belum diatur";
});

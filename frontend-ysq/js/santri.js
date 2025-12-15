import { api } from "./api.js";

document.addEventListener("DOMContentLoaded", loadSantri);

async function loadSantri() {
  try {
    const data = await api.get("/santri");
    const tbody = document.getElementById("santri-table-body");
    tbody.innerHTML = "";

    data.forEach((s, i) => {
      const tr = document.createElement("tr");
      tr.innerHTML = `
        <td>${i + 1}</td>
        <td>${s.nim ?? "-"}</td>
        <td>${s.nama}</td>
        <td>${s.kelas ?? "-"}</td>
        <td>${s.email ?? "-"}</td>
        <td>${s.jenjang ?? "-"}</td>
        <td>
          <button class="btn-action btn-edit">Edit</button>
          <button class="btn-action btn-delete">Hapus</button>
        </td>
      `;
      tbody.appendChild(tr);
    });
  } catch (e) {
    alert(e.message);
  }
}

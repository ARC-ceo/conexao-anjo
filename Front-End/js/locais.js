const btnAbrigos = document.getElementById("btnAbrigos");
const btnPostos = document.getElementById("btnPostos");
const lista = document.getElementById("listaLocais");

const apiAbrigos = "http://localhost:8080/abrigos";
const apiPostos = "http://localhost:8080/postos";

function renderAbrigos(abrigos) {
  lista.innerHTML = "";
  abrigos.forEach(ab => {
    const li = document.createElement("li");
    li.innerHTML = `
      <strong>${ab.nome}</strong><br/>
      Capacidade: ${ab.capacidade}<br/>
      Telefone: ${ab.telefone}<br/>
      Local: ${ab.localidade.cidade}, ${ab.localidade.uf}
    `;
    lista.appendChild(li);
  });
}

function renderPostos(postos) {
  lista.innerHTML = "";
  postos.forEach(p => {
    const li = document.createElement("li");
    li.innerHTML = `
      <strong>${p.nome}</strong><br/>
      ${p.descricao}<br/>
      Telefone: ${p.telefone}<br/>
      Local: ${p.localidade.cidade}, ${p.localidade.uf}
    `;
    lista.appendChild(li);
  });
}

async function carregarAbrigos() {
  btnAbrigos.classList.add("ativo");
  btnPostos.classList.remove("ativo");
  try {
    const response = await fetch(apiAbrigos);
    const data = await response.json();
    renderAbrigos(data);
  } catch (err) {
    alert("Erro ao carregar abrigos.");
  }
}

async function carregarPostos() {
  btnPostos.classList.add("ativo");
  btnAbrigos.classList.remove("ativo");
  try {
    const response = await fetch(apiPostos);
    const data = await response.json();
    renderPostos(data);
  } catch (err) {
    alert("Erro ao carregar postos de doação.");
  }
}

btnAbrigos.addEventListener("click", carregarAbrigos);
btnPostos.addEventListener("click", carregarPostos);

// Carrega abrigos por padrão
carregarAbrigos();

document.addEventListener("DOMContentLoaded", () => {
  const btnSair = document.getElementById("btnSair");

  if (btnSair) {
    btnSair.addEventListener("click", (e) => {
      e.preventDefault();
      // Limpa o localStorage (remove ID de login)
      localStorage.removeItem("loginId");

      // Redireciona para a tela de login
      window.location.href = "index.html";
    });
  }
});

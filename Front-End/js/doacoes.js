const apiDoacoes = "http://localhost:8080/itens";
const apiColaboradores = "http://localhost:8080/colab";

const listaDoacoes = document.getElementById("listaDoacoes");
const listaColaboradores = document.getElementById("listaColaboradores");
const guia = document.getElementById("guiaColaboradores");
const btnColaboradores = document.getElementById("btnColaboradores");
const btnFechar = document.getElementById("fecharGuia");

async function carregarDoacoes() {
  try {
    const res = await fetch(apiDoacoes);
    const doacoes = await res.json();
    listaDoacoes.innerHTML = "";

    doacoes.forEach(item => {
      const li = document.createElement("li");
      li.innerHTML = `
        <strong>${item.nome}</strong><br/>
        ${item.descricao}<br/>
        Categoria: ${item.categoria.nome}
      `;
      listaDoacoes.appendChild(li);
    });
  } catch (error) {
    alert("Erro ao carregar doações.");
  }
}

async function carregarColaboradores() {
  try {
    const res = await fetch(apiColaboradores);
    const colaboradores = await res.json();
    listaColaboradores.innerHTML = "";

    colaboradores.forEach(colab => {
      const li = document.createElement("li");
      li.innerHTML = `
        <strong>${colab.nome}</strong> (${colab.tipo})<br/>
        Tel: ${colab.telefone}
      `;
      listaColaboradores.appendChild(li);
    });

    guia.style.display = "flex";
  } catch (error) {
    alert("Erro ao carregar colaboradores.");
  }
}

btnColaboradores.addEventListener("click", carregarColaboradores);
btnFechar.addEventListener("click", () => guia.style.display = "none");

// Inicializa com lista de doações
carregarDoacoes();

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

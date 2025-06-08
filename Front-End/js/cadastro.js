const etapa1Form = document.getElementById("etapa1");
const etapa2Form = document.getElementById("etapa2");
const erroEl = document.getElementById("mensagemErro");
let loginId = null;

etapa1Form.addEventListener("submit", async (e) => {
  e.preventDefault();
  const email = document.getElementById("emailCadastro").value;
  const senha = document.getElementById("senhaCadastro").value;

  try {
    const response = await fetch("http://localhost:8080/usuario/cadastro", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ tipoConta: "U", email, senha })
    });

    if (!response.ok) {
      throw new Error("Email já está em uso");
    }

    const data = await response.json();
    loginId = data.id_login;

    etapa1Form.style.display = "none";
    etapa2Form.style.display = "block";
  } catch (err) {
    erroEl.textContent = err.message;
  }
});

etapa2Form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const nome = document.getElementById("nome").value;
  const telefone = document.getElementById("telefone").value;
  const uf = document.getElementById("uf").value;
  const cidade = document.getElementById("cidade").value;

  try {
    const response = await fetch("http://localhost:8080/usuario", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        nome,
        telefone,
        loginId,
        localidade: { uf, cidade }
      })
    });

    if (!response.ok) {
      throw new Error("Erro ao finalizar cadastro.");
    }

    localStorage.setItem("loginId", loginId);
    window.location.href = "locais.html"; // Redireciona para tela principal
  } catch (err) {
    erroEl.textContent = err.message;
  }
});

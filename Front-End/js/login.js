document.getElementById("loginForm").addEventListener("submit", async function (e) {
  e.preventDefault();

  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;
  const erroEl = document.getElementById("mensagemErro");

  try {
    const response = await fetch("http://localhost:8080/usuario/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, senha })
    });

    if (!response.ok) {
      throw new Error("Email ou senha incorretos");
    }

    const data = await response.json();
    localStorage.setItem("loginId", data.loginId); // Salva ID para outras telas

    window.location.href = "locais.html"; // Redireciona para a tela principal
  } catch (err) {
    erroEl.textContent = err.message;
  }
});

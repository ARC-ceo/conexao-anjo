const apiPerfil = "http://localhost:8080/usuario";
const loginId = localStorage.getItem("loginId");

if (!loginId) {
  alert("Você precisa estar logado para acessar o perfil.");
  window.location.href = "index.html";
}

const nomeInput = document.getElementById("nome");
const telefoneInput = document.getElementById("telefone");
const ufInput = document.getElementById("uf");
const cidadeInput = document.getElementById("cidade");

async function carregarPerfil() {
  try {
    const res = await fetch(`${apiPerfil}/${loginId}`);
    const usuario = await res.json();

    nomeInput.value = usuario.nome;
    telefoneInput.value = usuario.telefone;
    ufInput.value = usuario.localidade.uf;
    cidadeInput.value = usuario.localidade.cidade;
  } catch (err) {
    alert("Erro ao carregar perfil.");
  }
}

document.getElementById("editarPerfil").addEventListener("click", () => {
  nomeInput.disabled = false;
  telefoneInput.disabled = false;
  ufInput.disabled = false;
  cidadeInput.disabled = false;

  document.getElementById("salvarPerfil").style.display = "inline-block";
});

document.getElementById("salvarPerfil").addEventListener("click", async () => {
  const dadosAtualizados = {
    nome: nomeInput.value,
    telefone: telefoneInput.value,
    loginId: parseInt(loginId),
    localidade: {
      uf: ufInput.value,
      cidade: cidadeInput.value
    }
  };

  try {
    const res = await fetch(apiPerfil, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(dadosAtualizados)
    });

    if (res.ok) {
      alert("Perfil atualizado com sucesso!");
      nomeInput.disabled = true;
      telefoneInput.disabled = true;
      ufInput.disabled = true;
      cidadeInput.disabled = true;
      document.getElementById("salvarPerfil").style.display = "none";
    } else {
      alert("Erro ao atualizar perfil.");
    }
  } catch (err) {
    alert("Erro na requisição.");
  }
});

document.getElementById("deletarConta").addEventListener("click", async () => {
  if (confirm("Tem certeza que deseja deletar sua conta?")) {
    try {
      const res = await fetch(`${apiPerfil}/${loginId}`, {
        method: "DELETE"
      });

      if (res.ok) {
        alert("Conta deletada com sucesso.");
        localStorage.clear();
        window.location.href = "index.html";
      } else {
        alert("Erro ao deletar conta.");
      }
    } catch (err) {
      alert("Erro na requisição.");
    }
  }
});

document.addEventListener("DOMContentLoaded", () => {
  const btnSair = document.getElementById("btnSair");

  if (btnSair) {
    btnSair.addEventListener("click", (e) => {
      e.preventDefault();
      localStorage.removeItem("loginId");
      window.location.href = "index.html";
    });
  }

  carregarPerfil();
});

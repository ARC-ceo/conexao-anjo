package br.com.arc.bo;

import br.com.arc.beans.Login;
import br.com.arc.beans.Usuario;
import br.com.arc.dao.LocalidadeDAO;
import br.com.arc.dao.LoginDAO;
import br.com.arc.dao.UsuarioDAO;
import io.quarkus.logging.Log;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioBO {
    UsuarioDAO usuarioDAO;

    // login
    public Usuario loginBo(String email, String senha) throws ClassNotFoundException, SQLException {
        LoginDAO loginDAO = new LoginDAO();
        Login login = loginDAO.selecionar(email);

        if (login != null && senha.equals(login.getSenha())) {
            if ("U".equals(login.getTipoConta())) {
                usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.selecionar(login.getId());
                if (usuario != null) {
                    return usuario;
                }
            }
        }
        return null;
    }

    public int cadastrarBo(Login login) throws ClassNotFoundException, SQLException {
        LoginDAO loginDAO = new LoginDAO();
        if (loginDAO.selecionar(login.getEmail())==null) {
            return loginDAO.inserir(login);
        }
        else {
            return -1;
        }
    }

    public int inserirBo(Usuario usuario) throws ClassNotFoundException, SQLException {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.inserir(usuario);
    }

    public boolean atualizarBo(Usuario usuario) throws ClassNotFoundException, SQLException {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.alterar(usuario);
    }

    // Deletar
    public boolean deletarBo (int usuarioId) throws ClassNotFoundException, SQLException {
        usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.selecionar(usuarioId);
        if (usuario != null) {
            LocalidadeDAO localidadeDAO = new LocalidadeDAO();
            LoginDAO loginDAO = new LoginDAO();
            usuarioDAO.deletar(usuario.getId());
            loginDAO.deletar(usuario.getLoginId());
            localidadeDAO.deletar(usuario.getLocalidade().getId());
            return true;
        }
        else {return false;}
    }

    public Usuario buscarBo(int usuarioId) throws ClassNotFoundException, SQLException {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.selecionar(usuarioId);
    }
}

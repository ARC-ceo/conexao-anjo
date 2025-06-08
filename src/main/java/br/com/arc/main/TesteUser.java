package br.com.arc.main;

import br.com.arc.beans.Localidade;
import br.com.arc.beans.Usuario;
import br.com.arc.dao.UsuarioDAO;

import java.sql.SQLException;

public class TesteUser {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

            UsuarioDAO usuarioDAO = new UsuarioDAO();

            Localidade localidade = new Localidade();
            localidade.setUf("SC");
            localidade.setCidade("Santa Catarina");

            Usuario usuario = new Usuario();
            usuario.setNome("João da Silva");
            usuario.setTelefone("11999999999");
            usuario.setLocalidade(localidade);
            usuario.setLoginId(13);

            int idGerado = usuarioDAO.inserir(usuario);
            System.out.println("Usuário cadastrado com ID: " + idGerado);

    }
}

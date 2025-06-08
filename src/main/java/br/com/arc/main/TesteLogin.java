package br.com.arc.main;

import br.com.arc.beans.Login;
import br.com.arc.dao.LoginDAO;

import java.sql.SQLException;

public class TesteLogin {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
            Login novoLogin = new Login();
            novoLogin.setTipoConta("U");
            novoLogin.setEmail("teste@email.com");
            novoLogin.setSenha("123456");
            LoginDAO loginDAO = new LoginDAO();
            int idGerado = loginDAO.inserir(novoLogin);
            System.out.println("Login cadastrado com sucesso! ID gerado: " + idGerado);
    }
}

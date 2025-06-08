package br.com.arc.dao;

import br.com.arc.beans.ItemDoado;
import br.com.arc.beans.Login;
import br.com.arc.conexoes.ConexaoFactory;
import io.quarkus.logging.Log;

import java.sql.*;

public class LoginDAO {

    public Connection minhaConexao;

    public LoginDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public int inserir(Login login) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO login_ca (id_login, tipo_conta, email, senha) VALUES (SEQ_LOGIN.NEXTVAL, ?, ?, ?)"
        );

        stmt.setString(1, login.getTipoConta());
        stmt.setString(2, login.getEmail());
        stmt.setString(3, login.getSenha());
        stmt.executeUpdate();
        stmt.close();

        Statement stmt2 = minhaConexao.createStatement();
        ResultSet rs = stmt2.executeQuery("SELECT SEQ_LOGIN.CURRVAL FROM dual");

        int idGerado = -1;
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }

        rs.close();
        stmt2.close();
        return idGerado;
    }

    public Login selecionar(String email) throws SQLException {
        Login login = null;
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("SELECT id_login,tipo_conta,email,senha FROM LOGIN_CA WHERE email = ?");
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            login = new Login();
            login.setId(rs.getInt(1));
            login.setTipoConta(rs.getString(2));
            login.setEmail(rs.getString(3));
            login.setSenha(rs.getString(4));
        }
        rs.close();
        stmt.close();
        return login;
    }

    public boolean deletar(int idLogin) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("DELETE FROM LOGIN_CA WHERE id_login = ?");
        stmt.setInt(1, idLogin);
        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}

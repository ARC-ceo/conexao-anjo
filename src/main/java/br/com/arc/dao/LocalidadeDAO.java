package br.com.arc.dao;

import br.com.arc.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LocalidadeDAO {

    public Connection minhaConexao;

    public LocalidadeDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public boolean deletar(int idLocalidade) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("DELETE FROM LOCALIDADE_CA WHERE ID_LOCALIDADE = ?");
        stmt.setInt(1, idLocalidade);
        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

}

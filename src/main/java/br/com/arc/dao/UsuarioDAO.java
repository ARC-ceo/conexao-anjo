package br.com.arc.dao;

import br.com.arc.beans.Colaborador;
import br.com.arc.beans.Localidade;
import br.com.arc.beans.Usuario;
import br.com.arc.conexoes.ConexaoFactory;

import java.sql.*;

public class UsuarioDAO {

    public Connection minhaConexao;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public Usuario selecionar(int idLogin) throws SQLException {
        String sql = """
            SELECT
            c.ID_USUARIO,
            c.NOM_USUARIO,
            c.TELEFONE,
            l.UF_ESTADO,
            l.CIDADE,
            l.ID_LOCALIDADE
            FROM usuario_ca c
            JOIN localidade_CA l ON c.localidade_ID_LOCALIDADE = l.ID_LOCALIDADE
            WHERE c.LOGIN_ID_LOGIN = ?
            """;
        Usuario usuario = null;
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setInt(1, idLogin);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getInt(1));
            usuario.setNome(rs.getString(2));
            usuario.setTelefone(rs.getString(3));
            usuario.setLoginId(idLogin);
            Localidade localidade = new Localidade();
            localidade.setUf(rs.getString(4));
            localidade.setCidade(rs.getString(5));
            localidade.setId(rs.getInt(6));
            usuario.setLocalidade(localidade);
        }
        rs.close();
        stmt.close();
        return usuario;
    }

    public boolean deletar(int idUser) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("DELETE FROM USUARIO_CA WHERE ID_USUARIO = ?");

        stmt.setInt(1, idUser);
        int rowsAffected = stmt.executeUpdate();
        stmt.close();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean alterar(Usuario usuario) throws SQLException {
        PreparedStatement stmtUsuario = minhaConexao.prepareStatement
                ("UPDATE USUARIO_CA SET NOM_USUARIO = ?, TELEFONE = ? WHERE LOGIN_ID_LOGIN = ?");
        stmtUsuario.setString(1, usuario.getNome());
        stmtUsuario.setString(2, usuario.getTelefone());
        stmtUsuario.setInt(3, usuario.getLoginId());

        int rowsAffectedUser = stmtUsuario.executeUpdate();
        stmtUsuario.close();

        if (rowsAffectedUser == 0) {
            return false;
        }

        String sqlLocalidade = """
        UPDATE LOCALIDADE_CA 
        SET UF_ESTADO = ?, CIDADE = ? 
        WHERE ID_LOCALIDADE = (
            SELECT localidade_ID_LOCALIDADE 
            FROM USUARIO_CA 
            WHERE LOGIN_ID_LOGIN = ?
        )
        """;

        PreparedStatement stmtLocalidade = minhaConexao.prepareStatement(sqlLocalidade);
        stmtLocalidade.setString(1, usuario.getLocalidade().getUf());
        stmtLocalidade.setString(2, usuario.getLocalidade().getCidade());
        stmtLocalidade.setInt(3, usuario.getLoginId());

        stmtLocalidade.executeUpdate();
        stmtLocalidade.close();
        return true;
    }

    public int inserir(Usuario usuario) throws SQLException {

        String sqlLocalidade = "INSERT INTO LOCALIDADE_CA (ID_LOCALIDADE, UF_ESTADO, CIDADE) VALUES (SEQ_LOCALIDADE.NEXTVAL, ?, ?)";
        PreparedStatement stmtLocalidade = minhaConexao.prepareStatement(sqlLocalidade);
        stmtLocalidade.setString(1, usuario.getLocalidade().getUf());
        stmtLocalidade.setString(2, usuario.getLocalidade().getCidade());
        stmtLocalidade.executeUpdate();
        stmtLocalidade.close();

        Statement stmtBuscaLocalidade = minhaConexao.createStatement();
        ResultSet rsLocalidade = stmtBuscaLocalidade.executeQuery("SELECT SEQ_LOCALIDADE.CURRVAL FROM dual");

        int idLocalidade = -1;
        if (rsLocalidade.next()) {
            idLocalidade = rsLocalidade.getInt(1);
        }

        rsLocalidade.close();
        stmtBuscaLocalidade.close();

        String sqlUsuario = "INSERT INTO USUARIO_CA (ID_USUARIO, NOM_USUARIO, TELEFONE, LOCALIDADE_ID_LOCALIDADE, LOGIN_ID_LOGIN) VALUES (SEQ_USUARIO.NEXTVAL, ?, ?, ?, ?)";
        PreparedStatement stmtUsuario = minhaConexao.prepareStatement(sqlUsuario);
        stmtUsuario.setString(1, usuario.getNome());
        stmtUsuario.setString(2, usuario.getTelefone());
        stmtUsuario.setInt(3, idLocalidade);
        stmtUsuario.setInt(4, usuario.getLoginId());
        stmtUsuario.executeUpdate();
        stmtUsuario.close();

        Statement stmtBuscaUsuario = minhaConexao.createStatement();
        ResultSet rsUsuario = stmtBuscaUsuario.executeQuery("SELECT SEQ_USUARIO.CURRVAL FROM dual");

        int idUsuario = -1;
        if (rsUsuario.next()) {
            idUsuario = rsUsuario.getInt(1);
        }

        rsUsuario.close();
        stmtBuscaUsuario.close();
        return idUsuario;
    }
}

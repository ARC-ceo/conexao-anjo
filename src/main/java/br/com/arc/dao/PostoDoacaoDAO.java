package br.com.arc.dao;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.Localidade;
import br.com.arc.beans.PostoDoacao;
import br.com.arc.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostoDoacaoDAO {

    public Connection minhaConexao;

    public PostoDoacaoDAO() throws SQLException, ClassNotFoundException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    public List<PostoDoacao> selecionar() throws SQLException {
        String sql = """
            SELECT
                c.nom_posto,
                c.descricao,
                c.telefone,
                d.uf_estado,
                d.cidade
            FROM
                posto_doacao_ca  c
            INNER JOIN
                localidade_ca d ON (d.id_localidade=c.localidade_id_localidade)
            """;

        List<PostoDoacao> listaPostos = new ArrayList<PostoDoacao>();
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            PostoDoacao posto = new PostoDoacao();
            Localidade localidade = new Localidade();
            posto.setNome(rs.getString(1));
            posto.setDescricao(rs.getString(2));
            posto.setTelefone(rs.getString(3));
            localidade.setUf(rs.getString(4));
            localidade.setCidade(rs.getString(5));
            posto.setLocalidade(localidade);
            listaPostos.add(posto);
        }

        rs.close();
        stmt.close();
        return listaPostos;
    }
}

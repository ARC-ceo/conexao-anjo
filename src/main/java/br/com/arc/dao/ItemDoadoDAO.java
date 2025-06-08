package br.com.arc.dao;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.CategoriaDoacao;
import br.com.arc.beans.ItemDoado;
import br.com.arc.beans.Localidade;
import br.com.arc.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDoadoDAO {

    public Connection minhaConexao;

        public ItemDoadoDAO() throws SQLException, ClassNotFoundException {
            super();
            this.minhaConexao = new ConexaoFactory().conexao();
        }

    public List<ItemDoado> selecionar() throws SQLException {
        String sql = """
            SELECT
                c.nom_item,
                c.descricao,
                c.quantidade,
                d.nom_categoria
            FROM
                item_doado_ca  c
            INNER JOIN
                categoria_doacao_ca d ON (d.id_categoria=c.categoria_doacao_id_categoria)
            """;

        List<ItemDoado> listaItens = new ArrayList<ItemDoado>();
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ItemDoado itens = new ItemDoado();
            CategoriaDoacao categoria = new CategoriaDoacao();
            itens.setNome(rs.getString(1));
            itens.setDescricao(rs.getString(2));
            itens.setQuantidade(rs.getInt(3));
            categoria.setNome(rs.getString(4));
            itens.setCategoria(categoria);
            listaItens.add(itens);
        }

        rs.close();
        stmt.close();
        return listaItens;
    }
}

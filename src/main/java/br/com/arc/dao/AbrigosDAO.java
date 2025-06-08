package br.com.arc.dao;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.Localidade;
import br.com.arc.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbrigosDAO {

    public Connection minhaConexao;

        public AbrigosDAO() throws SQLException, ClassNotFoundException {
            super();
            this.minhaConexao = new ConexaoFactory().conexao();
        }

        public List<Abrigos> selecionar() throws SQLException {
            String sql = """
            SELECT 
                a.ID_ABRIGO,
                a.NOM_ABRIGO,
                a.CAPACIDADE,
                a.TELEFONE,
                l.UF_ESTADO,
                l.CIDADE
            FROM 
                abrigos_CA a
            JOIN 
                colaborador_CA c ON a.colaborador_ID_COLAB = c.ID_COLAB
            JOIN 
                localidade_CA l ON c.localidade_ID_LOCALIDADE = l.ID_LOCALIDADE
            """;

            List<Abrigos> listaAbrigos = new ArrayList<Abrigos>();
            PreparedStatement stmt = minhaConexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Abrigos abrigos = new Abrigos();
                Localidade localidade = new Localidade();
                abrigos.setId(rs.getInt(1));
                abrigos.setNome(rs.getString(2));
                abrigos.setCapacidade(rs.getInt(3));
                abrigos.setTelefone(rs.getString(4));
                localidade.setUf(rs.getString(5));
                localidade.setCidade(rs.getString(6));
                abrigos.setLocalidade(localidade);
                listaAbrigos.add(abrigos);
            }

            rs.close();
            stmt.close();
            return listaAbrigos;
        }
}

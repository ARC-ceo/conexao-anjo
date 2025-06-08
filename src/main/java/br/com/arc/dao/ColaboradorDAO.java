package br.com.arc.dao;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.Colaborador;
import br.com.arc.beans.Localidade;
import br.com.arc.beans.Login;
import br.com.arc.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDAO {

    public Connection minhaConexao;

        public ColaboradorDAO() throws SQLException, ClassNotFoundException {
            super();
            this.minhaConexao = new ConexaoFactory().conexao();
        }


        public List<Colaborador> selecionar() throws SQLException {
            String sql = """
            SELECT NOM_COLAB, TIPO, TELEFONE
            FROM COLABORADOR_CA
            """;
            List<Colaborador> listaColaboradores = new ArrayList<Colaborador>();
            PreparedStatement stmt = minhaConexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Colaborador colaborador = new Colaborador();
                colaborador.setNome(rs.getString(1));
                colaborador.setTipo(rs.getString(2));
                colaborador.setTelefone(rs.getString(3));
                listaColaboradores.add(colaborador);
            }

            rs.close();
            stmt.close();
            return listaColaboradores;
        }
}

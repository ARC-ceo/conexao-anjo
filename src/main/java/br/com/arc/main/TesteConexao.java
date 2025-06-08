package br.com.arc.main;

import br.com.arc.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection cn = new ConexaoFactory().conexao();

        System.out.println("Conectado com o Banco de Dados");

        cn.close();
    }
}

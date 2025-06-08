package br.com.arc.main;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.Localidade;
import br.com.arc.dao.AbrigosDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TesteAbrigos {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AbrigosDAO abrigosDAO = new AbrigosDAO();
        List<Abrigos> listaAbrigos = abrigosDAO.selecionar();

        for (Abrigos abrigo : listaAbrigos) {
            System.out.println("ID: " + abrigo.getId());
            System.out.println("Nome: " + abrigo.getNome());
            System.out.println("Capacidade: " + abrigo.getCapacidade());
            System.out.println("Telefone: " + abrigo.getTelefone());
            Localidade localidade = abrigo.getLocalidade();
            System.out.println("UF: " + localidade.getUf());
            System.out.println("Cidade: " + localidade.getCidade());
        }
    }
}

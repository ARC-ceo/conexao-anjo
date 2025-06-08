package br.com.arc.main;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.Colaborador;
import br.com.arc.beans.Localidade;
import br.com.arc.dao.AbrigosDAO;
import br.com.arc.dao.ColaboradorDAO;

import java.sql.SQLException;
import java.util.List;

public class TesteColab {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        List<Colaborador> listaColaboradores = colaboradorDAO.selecionar();

        for (Colaborador colaborador : listaColaboradores) {
            System.out.println("Nome: " + colaborador.getNome());
            System.out.println("Tipo: " + colaborador.getTipo());
            System.out.println("Telefone: " + colaborador.getTelefone());
        }
    }
}

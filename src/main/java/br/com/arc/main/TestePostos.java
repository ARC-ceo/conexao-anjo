package br.com.arc.main;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.Localidade;
import br.com.arc.beans.PostoDoacao;
import br.com.arc.dao.AbrigosDAO;
import br.com.arc.dao.PostoDoacaoDAO;

import java.sql.SQLException;
import java.util.List;

public class TestePostos {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PostoDoacaoDAO postoDoacaoDAO = new PostoDoacaoDAO();
        List<PostoDoacao> listaPostos = postoDoacaoDAO.selecionar();

        for (PostoDoacao posto : listaPostos) {
            System.out.println("Nome: " + posto.getNome());
            System.out.println("Descrição: " + posto.getDescricao());
            System.out.println("Telefone: " + posto.getTelefone());
            Localidade localidade = posto.getLocalidade();
            System.out.println("UF: " + localidade.getUf());
            System.out.println("Cidade: " + localidade.getCidade());
        }
    }
}

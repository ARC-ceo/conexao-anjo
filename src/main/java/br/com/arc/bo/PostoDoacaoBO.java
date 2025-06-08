package br.com.arc.bo;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.PostoDoacao;
import br.com.arc.dao.AbrigosDAO;
import br.com.arc.dao.PostoDoacaoDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostoDoacaoBO {

    PostoDoacaoDAO postoDoacaoDAO;


    // Selecionar
    public ArrayList<PostoDoacao> selecionarBo() throws ClassNotFoundException, SQLException, IOException {
        postoDoacaoDAO = new PostoDoacaoDAO();
        return (ArrayList<PostoDoacao>) postoDoacaoDAO.selecionar();
    }
}

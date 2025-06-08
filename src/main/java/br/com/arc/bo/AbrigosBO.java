package br.com.arc.bo;

import br.com.arc.beans.Abrigos;
import br.com.arc.dao.AbrigosDAO;
import br.com.arc.dao.UsuarioDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbrigosBO {
    AbrigosDAO abrigoDAO;


    // Selecionar
    public ArrayList<Abrigos> selecionarBo() throws ClassNotFoundException, SQLException, IOException {
        abrigoDAO = new AbrigosDAO();
        return (ArrayList<Abrigos>) abrigoDAO.selecionar();
    }
}

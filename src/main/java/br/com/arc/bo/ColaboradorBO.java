package br.com.arc.bo;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.Colaborador;
import br.com.arc.dao.AbrigosDAO;
import br.com.arc.dao.ColaboradorDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ColaboradorBO {

    ColaboradorDAO colaboradorDAO;


    // Selecionar
    public ArrayList<Colaborador> selecionarBo() throws ClassNotFoundException, SQLException, IOException {
        colaboradorDAO = new ColaboradorDAO();
        return (ArrayList<Colaborador>) colaboradorDAO.selecionar();
    }
}

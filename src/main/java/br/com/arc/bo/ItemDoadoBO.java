package br.com.arc.bo;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.ItemDoado;
import br.com.arc.dao.AbrigosDAO;
import br.com.arc.dao.ItemDoadoDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDoadoBO {

    ItemDoadoDAO itemDoadoDAO;

    // Selecionar
    public ArrayList<ItemDoado> selecionarBo() throws ClassNotFoundException, SQLException, IOException {
        itemDoadoDAO = new ItemDoadoDAO();
        return (ArrayList<ItemDoado>) itemDoadoDAO.selecionar();
    }
}

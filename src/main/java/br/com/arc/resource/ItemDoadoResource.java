package br.com.arc.resource;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.ItemDoado;
import br.com.arc.bo.AbrigosBO;
import br.com.arc.bo.ItemDoadoBO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@Path("/itens")
public class ItemDoadoResource {

    private ItemDoadoBO itemDoadoBO = new ItemDoadoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<ItemDoado> selecionarRs() throws ClassNotFoundException, SQLException, IOException {
        return itemDoadoBO.selecionarBo();
    }

}

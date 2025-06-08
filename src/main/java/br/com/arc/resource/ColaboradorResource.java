package br.com.arc.resource;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.Colaborador;
import br.com.arc.bo.AbrigosBO;
import br.com.arc.bo.ColaboradorBO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/colab")
public class ColaboradorResource {

    private ColaboradorBO colaboradorBO = new ColaboradorBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Colaborador> selecionarRs() throws ClassNotFoundException, SQLException, IOException {
        return colaboradorBO.selecionarBo();
    }
}

package br.com.arc.resource;

import br.com.arc.beans.Abrigos;
import br.com.arc.bo.AbrigosBO;
import br.com.arc.bo.UsuarioBO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/abrigos")
public class AbrigosResource {

    private AbrigosBO abrigosBO = new AbrigosBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Abrigos> selecionarRs() throws ClassNotFoundException, SQLException, IOException {
        return abrigosBO.selecionarBo();
    }
}

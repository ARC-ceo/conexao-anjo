package br.com.arc.resource;

import br.com.arc.beans.Abrigos;
import br.com.arc.beans.PostoDoacao;
import br.com.arc.bo.AbrigosBO;
import br.com.arc.bo.PostoDoacaoBO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@Path("/postos")
public class PostosResource {

    private PostoDoacaoBO postoDoacaoBO = new PostoDoacaoBO();

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PostoDoacao> selecionarRs() throws ClassNotFoundException, SQLException, IOException {
        return postoDoacaoBO.selecionarBo();
    }
}

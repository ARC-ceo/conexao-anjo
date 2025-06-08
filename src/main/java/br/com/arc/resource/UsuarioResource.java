package br.com.arc.resource;

import br.com.arc.beans.Login;
import br.com.arc.beans.Usuario;
import br.com.arc.bo.UsuarioBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioBO usuarioBO = new UsuarioBO();

    // fazer login
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response selecionarRs(Login login) throws ClassNotFoundException, SQLException {
        if (login == null || login.getEmail() == null || login.getSenha() == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("{\"mensagem\":\"Email e senha são obrigatórios.\"}")
                    .build();
        }

        Usuario usuario = usuarioBO.loginBo(login.getEmail(), login.getSenha());
        if (usuario == null) {
            return Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("{\"mensagem\":\"Email ou senha incorretos.\"}")
                    .build();
        }

        return Response
                .status(Response.Status.OK)
                .entity(usuario)
                .build();
    }

    // cadastrar informações de login
    @POST
    @Path("/cadastro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastroRS(Login login) throws SQLException, ClassNotFoundException {
        if (login.getEmail() == null || login.getSenha() == null || login.getTipoConta() == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("{\"mensagem\":\"Todos os campos são obrigatórios.\"}")
                    .build();
        }
        int idLogin = usuarioBO.cadastrarBo(login);
        if (idLogin != -1) {
            String json = String.format("{\"id_login\": %d}", idLogin);
            return Response.status(Response.Status.CREATED)
                    .entity(json)
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"mensagem\":\"Email já cadastrado.\"}")
                    .build();
        }
    }

    // cadastrar usuario
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response inserirBo(Usuario usuario) throws SQLException, ClassNotFoundException {
        if (usuario.getNome() == null || usuario.getTelefone() == null || usuario.getLocalidade() == null) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("{\"mensagem\":\"Todos os campos são obrigatórios.\"}")
                    .build();
        }
        int idUsuario = usuarioBO.inserirBo(usuario);
        if (idUsuario != -1) {
            String json = String.format("{\"id_usuario\": %d}", idUsuario);
            return Response.status(Response.Status.CREATED)
                    .entity(json)
                    .build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"mensagem\":\"Erro ao cadastrar usuario.\"}")
                    .build();
        }
    }

    // Atuallizar usuario
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRS(Usuario usuario) throws SQLException, ClassNotFoundException {
        boolean atualizado = usuarioBO.atualizarBo(usuario);
        if (usuario == null ) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("{\"mensagem\":\"Todos os campos são obrigatórios.\"}")
                    .build();
        }
        if (atualizado) {
            return Response.ok("{\"mensagem\":\"Usuario atualizado com sucesso.\"}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"mensagem\":\"Usuario não encontrado.\"}")
                    .build();
        }
    }

    // deletar usuario
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRS(@PathParam("id") int id) throws SQLException, ClassNotFoundException {
        boolean deletado = usuarioBO.deletarBo(id);
        if (deletado) {
            return Response.ok("{\"mensagem\":\"Usuario deletado com sucesso.\"}").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"mensagem\":\"Usuario não encontrado.\"}")
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        Usuario usuario = usuarioBO.buscarBo(id);
        if (usuario == null) {
            String mensagem = "{\"mensagem\":\"Usuário não encontrado\"}";
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(mensagem)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        return Response.ok(usuario).build();
    }
}

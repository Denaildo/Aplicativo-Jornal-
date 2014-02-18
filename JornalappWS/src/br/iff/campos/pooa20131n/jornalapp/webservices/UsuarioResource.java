package br.iff.campos.pooa20131n.jornalapp.webservices;

import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Usuario;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.UsuarioPersistence;

@Path("/usuario")
public class UsuarioResource {

	private UsuarioPersistence pusuario;

	public UsuarioResource() {
		try {
			InitialContext ctx = new InitialContext();
			pusuario = (UsuarioPersistence) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/UsuarioPersistence!br.iff.campos.pooa20131n.jornalapp.model.persistence.UsuarioPersistence");
		} catch (NamingException ne) {
			System.out.println("\n[MyRestService]NamingException: " + ne);
			ne.printStackTrace();
		}
	}

	@GET()
	@Produces("text/plain")
	public String sayHello() {
		Date date = new Date();
		return "Hello World! data agora ++++++++++++++++++++=> "
				+ date.toString();
	}

	@GET
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Usuario getUsuario(@PathParam("uid") String uid) {
		
		return  pusuario.find(uid);
	}
	
	@DELETE
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteUsuario(@PathParam("uid") String uid) {
		
		pusuario.delete(uid);
		return  Response.ok("").build();
	}
	
	@POST
	@Path("/{uid},{nome}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addUsuario(@PathParam("uid") String uid,@PathParam("nome") String nome) {
		
		pusuario.inserir(uid, "cpf", "email", nome);
		return  Response.ok("").build();
	}
	@PUT
	@Path("/{uid},{nome}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateUsuario(@PathParam("uid") String uid,@PathParam("nome") String nome) {
		
		pusuario.update(uid, "cpf", "email", nome);
		return  Response.ok("").build();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Usuario> getAll() {

		return pusuario.findAll();
	}
}
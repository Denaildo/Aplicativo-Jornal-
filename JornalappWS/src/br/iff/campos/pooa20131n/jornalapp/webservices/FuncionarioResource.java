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

import br.iff.campos.pooa20131n.jornalapp.model.entity.Funcionario;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.FuncionarioPèrsistence;;

@Path("/funcionario")
public class FuncionarioResource {
	private FuncionarioPèrsistence pfuncionario;

	public FuncionarioResource() {
	try {
			InitialContext ctx = new InitialContext();
			pfuncionario = (FuncionarioPèrsistence) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/FuncionarioPèrsistence!br.iff.campos.pooa20131n.jornalapp.model.persistence.FuncionarioPèrsistence");
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
	public Funcionario getFuncionario(@PathParam("uid") String uid) {
		
		return  pfuncionario.find(uid);
	}
	
	@DELETE
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteFuncionario(@PathParam("uid") String uid) {
		
		pfuncionario.delete(uid);
		return  Response.ok("").build();
	}
	
	@POST
	@Path("/{uid},{nome}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addFuncionario(@PathParam("uid") String uid,@PathParam("nome") String nome) {
		
		pfuncionario.inserir(uid, "cargo", "email", nome);
		return  Response.ok("").build();
	}
	@PUT
	@Path("/{uid},{nome}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateFuncionario(@PathParam("uid") String uid,@PathParam("nome") String nome) {
		
		pfuncionario.update(uid, "cargo", "email", nome);
		return  Response.ok("").build();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Funcionario> getAll() {

		return pfuncionario.findAll();
	}
}
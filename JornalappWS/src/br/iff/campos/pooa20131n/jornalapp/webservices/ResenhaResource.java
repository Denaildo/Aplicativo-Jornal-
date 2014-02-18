package br.iff.campos.pooa20131n.jornalapp.webservices;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
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
import br.iff.campos.pooa20131n.jornalapp.model.entity.Resenha;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EstabelecimentoPersistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.FuncionarioPèrsistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.ResenhaPersistencia;

@Path("/resenha")
public class ResenhaResource {

	private EstabelecimentoPersistence pestabelecimento;
	private FuncionarioPèrsistence pfuncionario;
	private ResenhaPersistencia presenha;

	DateFormat dia = new SimpleDateFormat("dd-MM-yy");
	DateFormat hora = new SimpleDateFormat("HH:mm");

	// SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");

	public ResenhaResource() {
		try {
			InitialContext ctx = new InitialContext();
			pfuncionario = (FuncionarioPèrsistence) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/FuncionarioPèrsistence!br.iff.campos.pooa20131n.jornalapp.model.persistence.FuncionarioPèrsistence");
		} catch (NamingException ne) {
			System.out.println("\n[MyRestService]NamingException: " + ne);
			ne.printStackTrace();
		}

		try {
			InitialContext ctx = new InitialContext();
			pestabelecimento = (EstabelecimentoPersistence) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/EstabelecimentoPersistence!br.iff.campos.pooa20131n.jornalapp.model.persistence.EstabelecimentoPersistence");
		} catch (NamingException ne) {
			System.out.println("\n[MyRestService]NamingException: " + ne);
			ne.printStackTrace();
		}

		try {
			InitialContext ctx = new InitialContext();
			presenha = (ResenhaPersistencia) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/ResenhaPersistencia!br.iff.campos.pooa20131n.jornalapp.model.persistence.ResenhaPersistencia");
		} catch (NamingException ne) {
			System.out.println("\n[MyRestService]NamingException: " + ne);
			ne.printStackTrace();
		}
	}

	@GET()
	@Produces("text/plain")
	public String sayHello() {
		Date date = new Date();
		return "Hello ITEM OrdemServico!++++++++++++++++++++=> "
				+ date.toString();
	}

	@GET
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Resenha getResenha(@PathParam("uid") String uid) {

		return presenha.find(uid);
	}

	@DELETE
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteResenha(@PathParam("uid") String uid) {

		presenha.delete(uid);
		return Response.ok("").build();
	}

	@POST
	@Path("/{uid},{resenha},{uidf},{uide}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addResenha(@PathParam("uid") String uid, @PathParam("resenha") String resenha,@PathParam("uidf") String uidf, @PathParam("uide") String uide){

		presenha.inserir(uid, resenha, pfuncionario.find(uidf), pestabelecimento.find(uide));
		return Response.ok("").build();
	}

	@PUT
	@Path("/{uid},{resenha},{uidf},{uide}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateResenha(@PathParam("uid") String uid,@PathParam("resenha") String resenha,@PathParam("uidf") String uidf, @PathParam("uide") String uide){

		presenha.update(uid, resenha, pfuncionario.find(uidf), pestabelecimento.find(uide));
		return Response.ok("").build();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Resenha> getAll() {

		return presenha.findAll();
	}
}
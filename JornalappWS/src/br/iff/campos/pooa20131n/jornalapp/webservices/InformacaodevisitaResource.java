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

import br.iff.campos.pooa20131n.jornalapp.model.entity.Informacaodevisita;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EstabelecimentoPersistence;

import br.iff.campos.pooa20131n.jornalapp.model.persistence.InformacaodevisitaPersistence;

import br.iff.campos.pooa20131n.jornalapp.model.persistence.UsuarioPersistence;

@Path("/informacao")
public class InformacaodevisitaResource {

	private InformacaodevisitaPersistence pinformacao;
	private UsuarioPersistence pusuario;
	private EstabelecimentoPersistence pestabelecimento;

	DateFormat dia = new SimpleDateFormat("dd-MM-yy");
	DateFormat hora = new SimpleDateFormat("HH:mm");

	// SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");

	public InformacaodevisitaResource() {
		try {
			InitialContext ctx = new InitialContext();
			pusuario = (UsuarioPersistence) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/UsuarioPersistence!br.iff.campos.pooa20131n.jornalapp.model.persistence.UsuarioPersistence");
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
			pinformacao = (InformacaodevisitaPersistence) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/InformacaodevisitaPersistence!br.iff.campos.pooa20131n.jornalapp.model.persistence.InformacaodevisitaPersistence");
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
	public Informacaodevisita getInformacaodevisita(@PathParam("uid") String uid) {

		return pinformacao.find(uid);
	}

	@DELETE
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteResenha(@PathParam("uid") String uid) {

		pinformacao.delete(uid);
		return Response.ok("").build();
	}

	@POST
	@Path("/{uid},{alimentos},{uidu},{uide}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addInformacaodevisita(@PathParam("uid") String uid, @PathParam("alimentos") String alimentos,@PathParam("uidu") String uidu, @PathParam("uide") String uide){
		pinformacao.inserir(uid,alimentos, 5, 10, pusuario.find(uidu), pestabelecimento.find(uide));
		
		return Response.ok("").build();
	}

	@PUT
	@Path("/{uid},{alimentos},{uidu},{uide}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateInformacaodevisita(@PathParam("uid") String uid, @PathParam("alimentos") String alimentos,@PathParam("uidu") String uidu, @PathParam("uide") String uide){
		pinformacao.update(uid,alimentos, 5, 10, pusuario.find(uidu), pestabelecimento.find(uide));
		
		return Response.ok("").build();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Informacaodevisita> getAll() {

		return pinformacao.findAll();
	}
}

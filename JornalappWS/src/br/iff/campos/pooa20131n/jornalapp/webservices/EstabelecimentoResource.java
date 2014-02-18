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

import br.iff.campos.pooa20131n.jornalapp.model.entity.Estabelecimento;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EstabelecimentoPersistence;

@Path("/estabelecimento")
public class EstabelecimentoResource {

	private EmpresaPersistence pempresa;
	private EstabelecimentoPersistence pestabelecimento;
	DateFormat formatter = new SimpleDateFormat("dd-MM-yy");  
	
	

	public EstabelecimentoResource() {
		
		
		try {
			InitialContext ctx = new InitialContext();
			pempresa = (EmpresaPersistence) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/EmpresaPersistence!br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence");
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
	public Estabelecimento getEstabelecimento(@PathParam("uid") String uid) {
		
		return  pestabelecimento.find(uid);
	}
	
	@DELETE
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteEstabelecimento(@PathParam("uid") String uid) {
		
		pestabelecimento.delete(uid);
		return  Response.ok("").build();
	}
	
	@POST
	@Path("/{uid},{ramo},{uide}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addEstabelecimento(@PathParam("uid") String uid,@PathParam("ramo") String ramo,@PathParam("uide") String uide) {
		pestabelecimento.inserir(uid, "endereco", "gerenteresponsavel", ramo, "telefone", pempresa.find(uide));
		return  Response.ok("").build();
	}
	@PUT
	@Path("/{uid},{ramo},{uide}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateEstabelecimento(@PathParam("uid") String uid,@PathParam("ramo") String ramo,@PathParam("uide") String uide) {
		pestabelecimento.update(uid, "endereco", "gerenteresponsavel", ramo, "telefone", pempresa.find(uide));
		return  Response.ok("").build();
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Estabelecimento> getAll() {

		return pestabelecimento.findAll();
	}
}
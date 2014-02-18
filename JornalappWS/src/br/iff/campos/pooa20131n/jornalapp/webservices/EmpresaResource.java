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
import br.iff.campos.pooa20131n.jornalapp.model.entity.Empresa;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence;

@Path("/empresa")
public class EmpresaResource {
	private EmpresaPersistence pempresa;

public EmpresaResource() {
	try {
			InitialContext ctx = new InitialContext();
			pempresa = (EmpresaPersistence) ctx
					.lookup("java:global/JornalAppEAR/JornalappEJB/EmpresaPersistence!br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence");
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
	public Empresa getEmpresa(@PathParam("uid") String uid) {
		
		return  pempresa.find(uid);
	}
	
	@DELETE
	@Path("/{uid}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteEmpresa(@PathParam("uid") String uid) {
		
		pempresa.delete(uid);
		return  Response.ok("").build();
	}
	
	@POST
	@Path("/{uid},{nomefantasia}")
	@Produces(MediaType.APPLICATION_XML)
	public Response addempresa(@PathParam("uid") String uid,@PathParam("nomefantasia") String nomefantasia) {
		
		pempresa.inserir(uid, "cnjp", "diretoresponsavel", nomefantasia, "razaosocial", "telefonesede");
		return  Response.ok("").build();
	}
	@PUT
	@Path("/{uid},{nomefantasia}")
	@Produces(MediaType.APPLICATION_XML)
	public Response updatEempresa(@PathParam("uid") String uid,@PathParam("nomefantasia") String nomefantasia) {
		
		pempresa.update(uid, "cnjp", "diretoresponsavel", nomefantasia, "razaosocial", "telefonesede");
		return  Response.ok("").build();
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Empresa> getAll() {
	
		return pempresa.findAll();
	}
}

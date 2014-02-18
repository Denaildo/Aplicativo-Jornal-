package br.iff.campos.pooa20131n.jornalapp.webservices;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class JornalappRESTApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public JornalappRESTApplication() {
		singletons.add(new UsuarioResource());
		singletons.add(new EmpresaResource());
		singletons.add(new FuncionarioResource());
		singletons.add(new EstabelecimentoResource());
		singletons.add(new ResenhaResource());
		singletons.add(new InformacaodevisitaResource());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}

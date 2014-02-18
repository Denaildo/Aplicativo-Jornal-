package br.iff.campos.pooa20131n.jornalapp.model.persistence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Estabelecimento;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Informacaodevisita;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Usuario;

@Stateless
@LocalBean
public class InformacaodevisitaPersistence extends AbstractPersistence {
	
	public Informacaodevisita inserir(String uid, String alimentosconsumidos, double avaliacao, float precototal, Usuario usuario, Estabelecimento estabelecimento){
		Informacaodevisita informacao = new Informacaodevisita();
		informacao.setUid(uid);
		informacao.setAlimentosconsumidos(alimentosconsumidos);
		informacao.setAvaliacao(avaliacao);
		informacao.setPrecototal(precototal);
		informacao.setUsuario(usuario);
		informacao.setEstabelecimento(estabelecimento);
		super.insert(informacao);
		
		return informacao;
	}
	public Informacaodevisita update(String uid, String alimentosconsumidos, double avaliacao, float precototal, Usuario usuario, Estabelecimento estabelecimento){
		Informacaodevisita informacao = super.find(Informacaodevisita.class, uid);
		informacao.setUid(uid);
		informacao.setAlimentosconsumidos(alimentosconsumidos);
		informacao.setAvaliacao(avaliacao);
		informacao.setPrecototal(precototal);
		informacao.setUsuario(usuario);
		informacao.setEstabelecimento(estabelecimento);
		super.update(informacao);
		
		return informacao;
	}
	
	public Informacaodevisita find(String uid) {

		return super.find(Informacaodevisita.class, uid);
	}

	public void delete(String uid) {
		super.delete(Informacaodevisita.class, uid);
	}

	public List<Informacaodevisita> findAll() {
		return super.findAll(Informacaodevisita.class);

	}

}

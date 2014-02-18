package br.iff.campos.pooa20131n.jornalapp.model.persistence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Empresa;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Estabelecimento;

@Stateless
@LocalBean
public class EstabelecimentoPersistence extends AbstractPersistence{

	public Estabelecimento inserir(String uid, String endereco, String gerenteresponsavel, String ramo, String telefone, Empresa empresa){
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setUid(uid);
		estabelecimento.setEndereco(endereco);
		estabelecimento.setGerenteresponsavel(gerenteresponsavel);
		estabelecimento.setRamo(ramo);
		estabelecimento.setTelefone(telefone);
		estabelecimento.setEmpresa(empresa);
		super.insert(estabelecimento);
		return estabelecimento;
	}
	
	public Estabelecimento update(String uid, String endereco, String gerenteresponsavel, String ramo, String telefone, Empresa empresa){
		Estabelecimento estabelecimento = super.find(Estabelecimento.class, uid);
		estabelecimento.setUid(uid);
		estabelecimento.setEndereco(endereco);
		estabelecimento.setGerenteresponsavel(gerenteresponsavel);
		estabelecimento.setRamo(ramo);
		estabelecimento.setTelefone(telefone);
		estabelecimento.setEmpresa(empresa);
		super.update(estabelecimento);
		return estabelecimento;
	}
	
	public Estabelecimento find(String uid) {
		return super.find(Estabelecimento.class, uid);
	}



	public List<Estabelecimento> findAll() {
		return super.findAll(Estabelecimento.class);

	}
	
	public void delete(String uid) {
		super.delete(Estabelecimento.class, uid);
	}
	
}

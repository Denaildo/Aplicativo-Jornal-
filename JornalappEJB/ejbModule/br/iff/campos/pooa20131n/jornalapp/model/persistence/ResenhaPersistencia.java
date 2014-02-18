package br.iff.campos.pooa20131n.jornalapp.model.persistence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Estabelecimento;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Funcionario;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Resenha;

@Stateless
@LocalBean
public class ResenhaPersistencia extends AbstractPersistence {

	public Resenha inserir(String uid, String resenha, Funcionario funcionario, Estabelecimento estabelecimento){
		Resenha resenhaa = new Resenha();
		resenhaa.setUid(uid);
		resenhaa.setResenha(resenha);
		resenhaa.setFuncionario(funcionario);
		resenhaa.setEstabelecimento(estabelecimento);
		super.insert(resenhaa);
		return resenhaa;
	}
	
	public Resenha update(String uid, String resenha, Funcionario funcionario, Estabelecimento estabelecimento){
		Resenha resenhaa = super.find(Resenha.class, uid);
		resenhaa.setUid(uid);
		resenhaa.setResenha(resenha);
		resenhaa.setFuncionario(funcionario);
		resenhaa.setEstabelecimento(estabelecimento);
		super.insert(resenhaa);
		return resenhaa;
	}
	
	public Resenha find(String uid) {

		return super.find(Resenha.class, uid);
	}

	

	public List<Resenha> findAll() {
		return super.findAll(Resenha.class);

	}
	
	public void delete(String uid) {
		super.delete(Resenha.class, uid);
	}
}

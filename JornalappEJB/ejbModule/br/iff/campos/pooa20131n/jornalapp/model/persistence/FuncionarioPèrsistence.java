package br.iff.campos.pooa20131n.jornalapp.model.persistence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Funcionario;

@Stateless
@LocalBean
public class FuncionarioPèrsistence extends AbstractPersistence {	
	public Funcionario inserir(String uid, String cargo, String email,
			String nome) {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setUid(uid);
		funcionario.setCargo(cargo);
		funcionario.setEmail(email);
		funcionario.setNome(nome);
		super.insert(funcionario);
	
		return funcionario;

	}

	public Funcionario update(String uid, String cargo, String email,String nome) {
			Funcionario funcionario = super.find(Funcionario.class, uid);
			
			funcionario.setUid(uid);
			funcionario.setCargo(cargo);
			funcionario.setEmail(email);
			funcionario.setNome(nome);
			super.update(funcionario);
			return funcionario;

		}
	
	public Funcionario find(String uid) {

		return super.find(Funcionario.class, uid);
	}

	public void delete(String uid) {
		super.delete(Funcionario.class, uid);
	}

	public List<Funcionario> findAll() {
		return super.findAll(Funcionario.class);

	}

	
	
}
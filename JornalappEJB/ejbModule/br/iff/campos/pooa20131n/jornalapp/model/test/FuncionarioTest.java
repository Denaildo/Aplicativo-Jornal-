package br.iff.campos.pooa20131n.jornalapp.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Funcionario;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.FuncionarioPèrsistence;

public class FuncionarioTest {
	
	private FuncionarioPèrsistence ffunc = new FuncionarioPèrsistence(); 
	private String uid = "001";
	
	@Test
	public void testInserir() {
		Funcionario func = ffunc.inserir(uid, "cargo", "email", "nome");
		assertEquals(func.getUid(),uid);
	}


	@Test
	public void testUpdate() {
		Funcionario func = ffunc.update(uid, "cargo", "emailAA", "nome");
		assertEquals(func.getEmail(),"emailAA");
	}

	@Test
	public void testFind() {
		Funcionario func = ffunc.find(uid);
		assertEquals(func.getCargo(), "cargo");
	}

	

	@Test
	public void testFindAll() {
		List<Funcionario> lfunc = ffunc.findAll();
		for (Funcionario func : lfunc){
			assertEquals(func.getNome(), "nome");
		}
	}
	
	@Test
	public void testDelete() {
		ffunc.delete(uid);
		
	}

}
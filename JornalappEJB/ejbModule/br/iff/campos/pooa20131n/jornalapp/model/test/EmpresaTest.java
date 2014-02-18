package br.iff.campos.pooa20131n.jornalapp.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;


import br.iff.campos.pooa20131n.jornalapp.model.entity.Empresa;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence;


public class EmpresaTest {
	private EmpresaPersistence eempr = new EmpresaPersistence();
	private String uid = "001";
	@Test
	public void testInserir() {
		Empresa empr = eempr.inserir(uid, "cnpj", "diretoresponsavel", "nomefantasia", "razaosocial", "telefonesede");
		assertEquals(empr.getUid(),uid);
	}


	@Test
	public void testUpdate() {
		Empresa empr = eempr.update(uid, "cnpj", "diretoresponsavel", "nomefantasiaD", "razaosocial", "telefonesede");
		assertEquals(empr.getNomefantasia(),"nomefantasiaD");
	}

	@Test
	public void testFind() {
		Empresa empr = eempr.find(uid);
		assertEquals(empr.getCnjp().trim(),"cnpj");
	}

	

	@Test
	public void testFindAll() {
		List<Empresa> lempr = eempr.findAll();
		for (Empresa empr : lempr){
			assertEquals(empr.getRazaosocial(), "razaosocial");
		}
	}
	
	@Test
	public void testDelete() {
		eempr.delete(uid);
		
	}

}
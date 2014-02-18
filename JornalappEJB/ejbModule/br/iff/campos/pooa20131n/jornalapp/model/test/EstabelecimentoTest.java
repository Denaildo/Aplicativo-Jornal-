package br.iff.campos.pooa20131n.jornalapp.model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.List;
import java.util.UUID;
import org.junit.Test;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Empresa;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Estabelecimento;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EstabelecimentoPersistence;

public class EstabelecimentoTest {
	private EmpresaPersistence pempr = new EmpresaPersistence();
	private EstabelecimentoPersistence pesta = new EstabelecimentoPersistence();

	private String uid = "001";

	@Test
	public void testInserir() {
		pempr.inserir(uid, "cnjp", "diretoresponsavel", "nomefantasia",
				"razaosocial", "telefonesede");
		Estabelecimento esta = pesta.inserir(uid, "endereco",
				"gerenteresponsavel", "ramo", "telefone", pempr.find(uid));
		assertEquals(esta.getUid(), uid);
	}

	@Test
	public void testUpdate() {
		Estabelecimento esta = pesta.update(uid, "endereco",
				"gerenteresponsavel", "ram00", "telefone", pempr.find(uid));
		assertEquals(esta.getRamo(), "ram00");
	}

	@Test
	public void testFind() {
		Estabelecimento esta = pesta.find(uid);
		assertEquals(esta.getEndereco(), "endereco");
	}

	@Test
	public void testFindAll() {
		List<Estabelecimento> lesta = pesta.findAll();
		for (Estabelecimento esta : lesta) {
			assertEquals(esta.getGerenteresponsavel(), "gerenteresponsavel");
		}
	}

	@Test
	public void testDelete() {

		pesta.delete(uid);
		pempr.delete(uid);
	}

}

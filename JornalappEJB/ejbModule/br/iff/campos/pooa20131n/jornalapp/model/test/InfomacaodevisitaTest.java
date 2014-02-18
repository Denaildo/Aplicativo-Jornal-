package br.iff.campos.pooa20131n.jornalapp.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Informacaodevisita;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Resenha;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EstabelecimentoPersistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.InformacaodevisitaPersistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.UsuarioPersistence;

public class InfomacaodevisitaTest {
	private UsuarioPersistence pusua = new UsuarioPersistence();
	private EstabelecimentoPersistence pesta = new EstabelecimentoPersistence();
	private EmpresaPersistence pempr = new EmpresaPersistence();
	private InformacaodevisitaPersistence pinfo = new InformacaodevisitaPersistence();
	private String uid = "001";
	@Test
	public void testInserir() {
		pempr.inserir(uid, "cnpj", "diretoresponsavel", "nomefantasia", "razaosocial", "telefonesede");
		pesta.inserir(uid, "endereco", "gerenteresponsavel", "ramo", "telefone", pempr.find(uid));
		pusua.inserir(uid, "cpf", "email", "nome");
		Informacaodevisita info = pinfo.inserir(uid, "alimentosconsumidos", 23.0, 12, pusua.find(uid), pesta.find(uid));
		
		assertEquals(info.getUid(),uid);
	}
	@Test
	public void testUpdate() {
		Informacaodevisita info = pinfo.update(uid, "alimentosconsumidos0", 23.0, 12, pusua.find(uid), pesta.find(uid));
		assertEquals(info.getAlimentosconsumidos(), "alimentosconsumidos0");
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testFind() {
		Informacaodevisita info = pinfo.find(uid);
		assertEquals(info.getUsuario(), pusua.find(uid));
	
	}
	

	@Test
	public void testFindAll() {
		List<Informacaodevisita> linfo = pinfo.findAll();
		for (Informacaodevisita info : linfo){
			assertEquals(info.getUsuario(), pusua.find(uid));
		}
	}
	
	@Test
	public void testDelete() {
		pinfo.delete(uid);
		pusua.delete(uid);
		pesta.delete(uid);
		pempr.delete(uid);
		
	}
	
}

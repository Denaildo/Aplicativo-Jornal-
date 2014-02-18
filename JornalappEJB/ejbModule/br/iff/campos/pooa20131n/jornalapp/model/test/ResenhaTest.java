package br.iff.campos.pooa20131n.jornalapp.model.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Empresa;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Estabelecimento;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Resenha;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EstabelecimentoPersistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.FuncionarioPèrsistence;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.ResenhaPersistencia;

public class ResenhaTest{
	private FuncionarioPèrsistence pfunc = new FuncionarioPèrsistence();
	private EstabelecimentoPersistence pesta = new EstabelecimentoPersistence();
	private EmpresaPersistence pempr = new EmpresaPersistence();
	private ResenhaPersistencia prese = new ResenhaPersistencia();
	private String uid = "001";
	@Test
	public void testInserir() {
		pempr.inserir(uid, "cnpj", "diretoresponsavel", "nomefantasia", "razaosocial", "telefonesede");
		pesta.inserir(uid, "endereco", "gerenteresponsavel", "ramo", "telefone", pempr.find(uid));
		pfunc.inserir(uid, "cargo", "email", "nome");
		Resenha rese = prese.inserir(uid, "resenha", pfunc.find(uid), pesta.find(uid));
		assertEquals(rese.getUid(),uid);
	}
	@Test
	public void testUpdate() {
		Resenha rese = prese.update(uid, "resenha0", pfunc.find(uid), pesta.find(uid));
		assertEquals(rese.getResenha(),"resenha0");
	}
	@Test
	public void testFind() {
		Resenha rese = prese.find(uid);
		assertEquals(rese.getFuncionario(), pfunc.find(uid));
	}
	

	@Test
	public void testFindAll() {
		List<Resenha> lrese = prese.findAll();
		for (Resenha rese : lrese){
			assertEquals(rese.getEstabelecimento(), pesta.find(uid));
		}
	}
	
	@Test
	public void testDelete() {
		prese.delete(uid);
		pesta.delete(uid);
		pempr.delete(uid);
		pfunc.delete(uid);
	}
}

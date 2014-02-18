package br.iff.campos.pooa20131n.jornalapp.model.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Usuario;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.UsuarioPersistence;


public class UsuarioTest {
		
		private UsuarioPersistence uusua = new UsuarioPersistence();
		private String uid = "001";
		@Test
		public void testInserir() {
			Usuario usua = uusua.inserir(uid, "cpf", "email", "nome");
			assertEquals(usua.getUid(),uid);
		}


		@Test
		public void testUpdate() {
			Usuario usua = uusua.update(uid, "cpf", "emailAA", "nome");
			assertEquals(usua.getEmail(),"emailAA");
		}

		@Test
		public void testFind() {
			Usuario usua = uusua.find(uid);
			assertEquals(usua.getCpf(), "cpf");
		}

		

		@Test
		public void testFindAll() {
			List<Usuario> lusua = uusua.findAll();
			for (Usuario usua : lusua){
				assertEquals(usua.getNome(), "nome");
			}
		}
		
		@Test
		public void testDelete() {
			uusua.delete(uid);
			
		}

	}



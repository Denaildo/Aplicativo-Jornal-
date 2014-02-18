package br.iff.campos.pooa20131n.jornalapp.model.persistence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Usuario;


@Stateless
@LocalBean
public class UsuarioPersistence extends AbstractPersistence {	
	public Usuario inserir(String uid, String cpf, String email,
			String nome) {
		Usuario usuario = new Usuario();
		
		usuario.setUid(uid);
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setNome(nome);
		super.insert(usuario);
		return usuario;

	}

	public Usuario update(String uid, String cpf, String email,
			String nome) {
		Usuario usuario = super.find(Usuario.class, uid);
		
		usuario.setUid(uid);
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setNome(nome);
		super.update(usuario);
		return usuario;

	}
	
	public Usuario find(String uid) {

		return super.find(Usuario.class, uid);
	}

	public void delete(String uid) {
		super.delete(Usuario.class, uid);
	}

	public List<Usuario> findAll() {
		return super.findAll(Usuario.class);

	}

	
	
}
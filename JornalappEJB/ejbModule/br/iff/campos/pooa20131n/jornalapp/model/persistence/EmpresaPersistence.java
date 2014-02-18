package br.iff.campos.pooa20131n.jornalapp.model.persistence;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.iff.campos.pooa20131n.jornalapp.model.entity.Empresa;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Usuario;

@Stateless
@LocalBean
public class EmpresaPersistence extends AbstractPersistence{
	public Empresa inserir( String uid, String cnjp, String diretoresponsavel, String nomefantasia, String razaosocial, String telefonesede) {
		Empresa empresa = new Empresa();
		empresa.setUid(uid);
		empresa.setCnjp(cnjp);
		empresa.setDiretoresponsavel(diretoresponsavel);
		empresa.setNomefantasia(nomefantasia);
		empresa.setRazaosocial(razaosocial);
		empresa.setTelefonesede(telefonesede);
		super.insert(empresa);
	
		return empresa;

	}

	public Empresa update (String uid, String cnjp, String diretoresponsavel, String nomefantasia, String razaosocial, String telefonesede) {
		Empresa empresa = super.find(Empresa.class, uid);
		empresa.setUid(uid);
		empresa.setCnjp(cnjp);
		empresa.setDiretoresponsavel(diretoresponsavel);
		empresa.setNomefantasia(nomefantasia);
		empresa.setRazaosocial(razaosocial);
		empresa.setTelefonesede(telefonesede);
		super.update(empresa);
	
		return empresa;
	}
	
	public Empresa find(String uid) {

		return super.find(Empresa.class, uid);
	}


	public List<Empresa> findAll() {
		return super.findAll(Empresa.class);

	}

	public void delete(String uid) {
		super.delete(Empresa.class, uid);
	}
	
	
}

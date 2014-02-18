package br.iff.campos.pooa2013n.jornalapp.web.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Usuario;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.UsuarioPersistence;

@ManagedBean(name = "usuarioweb")
@RequestScoped
public class UsuarioWebController {

	@EJB(lookup = "java:app/JornalappEJB/UsuarioPersistence")
	private UsuarioPersistence jusuario;
	private Usuario usuario;

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public List<Usuario> getAllUsuario() {
		return jusuario.findAll();
	}

	public String salva() {

		if (jusuario.find(usuario.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario Ja Cadastrado"));

		} else {
			jusuario.insert(usuario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		return "ok";
	}

	public String delete() {

		if (jusuario.find(usuario.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario não Existe"));

		} else {
			jusuario.delete(usuario.getUid());

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario Excluido!"));
		}
		return "ok";
	}

	public String update() {

		if (jusuario.find(usuario.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario não Existe"));

		} else {
			jusuario.update(usuario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		return "ok";
	}

	public String busca() {

		usuario = jusuario.find(usuario.getUid());
		if (usuario == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario não Existe"));

		} else {
			jusuario.update(usuario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(""));
		}
		return "ok";
	}

	public UsuarioWebController() {

	}

}
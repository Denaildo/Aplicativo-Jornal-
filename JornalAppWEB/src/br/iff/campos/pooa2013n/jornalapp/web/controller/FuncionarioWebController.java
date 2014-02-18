package br.iff.campos.pooa2013n.jornalapp.web.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Funcionario;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.FuncionarioPèrsistence;

@ManagedBean(name = "funcionarioweb")
@RequestScoped
public class FuncionarioWebController {

	@EJB(lookup = "java:app/JornalappEJB/FuncionarioPèrsistence")
	private FuncionarioPèrsistence jfuncionario;
	private Funcionario funcionario;

	public Funcionario getFuncionario() {
		if (funcionario == null) {
			funcionario = new Funcionario();
		}
		return funcionario;
	}

	public List<Funcionario> getAllFuncionario() {
		return jfuncionario.findAll();
	}

	public String salva() {

		if (jfuncionario.find(funcionario.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Funcionario Ja Cadastrado"));

		} else {
			jfuncionario.insert(funcionario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		return "ok";
	}

	public String delete() {

		if (jfuncionario.find(funcionario.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario não Existe"));

		} else {
			jfuncionario.delete(funcionario.getUid());

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Usuario Excluido!"));
		}
		return "ok";
	}

	public String update() {

		if (jfuncionario.find(funcionario.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Funcionario não Existe"));

		} else {
			jfuncionario.update(funcionario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		return "ok";
	}
	
	public String busca() {

		funcionario = jfuncionario.find(funcionario.getUid());
		if (funcionario == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Funcionario não Existe"));

		} else {
			jfuncionario.update(funcionario);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(""));
		}
		return "ok";
	}
	public FuncionarioWebController() {

	}

}
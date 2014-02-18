package br.iff.campos.pooa2013n.jornalapp.web.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.iff.campos.pooa20131n.jornalapp.model.entity.Empresa;
import br.iff.campos.pooa20131n.jornalapp.model.persistence.EmpresaPersistence;

@ManagedBean(name = "empresaweb")
@RequestScoped
public class EmpresaWebController {

	@EJB(lookup = "java:app/JornalappEJB/EmpresaPersistence")
	private EmpresaPersistence jempresa;
	private Empresa empresa;

	public Empresa getEmpresa() {
		if (empresa == null) {
			empresa = new Empresa();
		}
		return empresa;
	}

	public List<Empresa> getAllEmpresa() {
		return jempresa.findAll();
	}

	public String salva() {

		if (jempresa.find(empresa.getUid()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa Ja Cadastrado"));

		} else {
			jempresa.insert(empresa);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		return "ok";
	}

	public String delete() {

		if (jempresa.find(empresa.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa não Existe"));

		} else {
			jempresa.delete(empresa.getUid());

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa Excluido!"));
		}
		return "ok";
	}

	public String update() {

		if (jempresa.find(empresa.getUid()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa não Existe"));

		} else {
			jempresa.update(empresa);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		return "ok";
	}

	public String busca() {

		empresa = jempresa.find(empresa.getUid());
		if (empresa == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Empresa não Existe"));

		} else {
			jempresa.update(empresa);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage(""));
		}
		return "ok";
	}

	public EmpresaWebController() {

	}

}
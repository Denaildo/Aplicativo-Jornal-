package br.iff.campos.pooa20131n.jornalapp.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@XmlRootElement
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String cnjp;

	private String diretoresponsavel;

	private String nomefantasia;

	private String razaosocial;

	private String telefonesede;

	// bi-directional many-to-one association to Estabelecimento
	@OneToMany(mappedBy = "empresa")
	private List<Estabelecimento> estabelecimentos;

	public Empresa() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCnjp() {
		return this.cnjp;
	}

	public void setCnjp(String cnjp) {
		this.cnjp = cnjp;
	}

	public String getDiretoresponsavel() {
		return this.diretoresponsavel;
	}

	public void setDiretoresponsavel(String diretoresponsavel) {
		this.diretoresponsavel = diretoresponsavel;
	}

	public String getNomefantasia() {
		return this.nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getRazaosocial() {
		return this.razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getTelefonesede() {
		return this.telefonesede;
	}

	public void setTelefonesede(String telefonesede) {
		this.telefonesede = telefonesede;
	}

	@XmlTransient
	public List<Estabelecimento> getEstabelecimentos() {
		return this.estabelecimentos;
	}

	public void setEstabelecimentos(List<Estabelecimento> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

	public Estabelecimento addEstabelecimento(Estabelecimento estabelecimento) {
		getEstabelecimentos().add(estabelecimento);
		estabelecimento.setEmpresa(this);

		return estabelecimento;
	}

	public Estabelecimento removeEstabelecimento(Estabelecimento estabelecimento) {
		getEstabelecimentos().remove(estabelecimento);
		estabelecimento.setEmpresa(null);

		return estabelecimento;
	}

}
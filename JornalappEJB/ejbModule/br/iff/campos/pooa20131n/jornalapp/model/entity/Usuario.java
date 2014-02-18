package br.iff.campos.pooa20131n.jornalapp.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@XmlRootElement
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String cpf;

	private String email;

	private String nome;

	// bi-directional many-to-one association to Informacaodevisita
	@OneToMany(mappedBy = "usuario")
	private List<Informacaodevisita> informacaodevisitas;

	public Usuario() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlTransient
	public List<Informacaodevisita> getInformacaodevisitas() {
		return this.informacaodevisitas;
	}

	public void setInformacaodevisitas(
			List<Informacaodevisita> informacaodevisitas) {
		this.informacaodevisitas = informacaodevisitas;
	}

	public Informacaodevisita addInformacaodevisita(
			Informacaodevisita informacaodevisita) {
		getInformacaodevisitas().add(informacaodevisita);
		informacaodevisita.setUsuario(this);

		return informacaodevisita;
	}

	public Informacaodevisita removeInformacaodevisita(
			Informacaodevisita informacaodevisita) {
		getInformacaodevisitas().remove(informacaodevisita);
		informacaodevisita.setUsuario(null);

		return informacaodevisita;
	}

}
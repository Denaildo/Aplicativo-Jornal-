package br.iff.campos.pooa20131n.jornalapp.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@XmlRootElement
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String cargo;

	private String email;

	private String nome;

	//bi-directional many-to-one association to Resenha
	@OneToMany(mappedBy="funcionario")
	private List<Resenha> resenhas;

	public Funcionario() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	public List<Resenha> getResenhas() {
		return this.resenhas;
	}

	public void setResenhas(List<Resenha> resenhas) {
		this.resenhas = resenhas;
	}

	public Resenha addResenha(Resenha resenha) {
		getResenhas().add(resenha);
		resenha.setFuncionario(this);

		return resenha;
	}

	public Resenha removeResenha(Resenha resenha) {
		getResenhas().remove(resenha);
		resenha.setFuncionario(null);

		return resenha;
	}

}
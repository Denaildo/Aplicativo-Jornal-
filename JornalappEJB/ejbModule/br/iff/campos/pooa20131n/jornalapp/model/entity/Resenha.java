package br.iff.campos.pooa20131n.jornalapp.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the resenha database table.
 * 
 */
@Entity
@XmlRootElement
public class Resenha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String resenha;

	//bi-directional many-to-one association to Estabelecimento
	@ManyToOne
	@JoinColumn(name="uidestabelecimento")
	private Estabelecimento estabelecimento;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="uidfuncionario")
	private Funcionario funcionario;

	public Resenha() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getResenha() {
		return this.resenha;
	}

	public void setResenha(String resenha) {
		this.resenha = resenha;
	}
	
	public Estabelecimento getEstabelecimento() {
		return this.estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
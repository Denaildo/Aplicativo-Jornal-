package br.iff.campos.pooa20131n.jornalapp.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the informacaodevisita database table.
 * 
 */
@Entity
@XmlRootElement
public class Informacaodevisita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String alimentosconsumidos;

	private double avaliacao;

	private float precototal;

	//bi-directional many-to-one association to Estabelecimento
	@ManyToOne
	@JoinColumn(name="uidestabelecimento")
	private Estabelecimento estabelecimento;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="uidusuario")
	private Usuario usuario;

	public Informacaodevisita() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getAlimentosconsumidos() {
		return this.alimentosconsumidos;
	}

	public void setAlimentosconsumidos(String alimentosconsumidos) {
		this.alimentosconsumidos = alimentosconsumidos;
	}

	public double getAvaliacao() {
		return this.avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public float getPrecototal() {
		return this.precototal;
	}

	public void setPrecototal(float precototal) {
		this.precototal = precototal;
	}
	public Estabelecimento getEstabelecimento() {
		return this.estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
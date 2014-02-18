package br.iff.campos.pooa20131n.jornalapp.model.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 * The persistent class for the estabelecimento database table.
 * 
 */
@Entity
@XmlRootElement
public class Estabelecimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uid;

	private String endereco;

	private String gerenteresponsavel;

	private String ramo;

	private String telefone;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="uidempresa")
	private Empresa empresa;

	//bi-directional many-to-one association to Informacaodevisita
	@OneToMany(mappedBy="estabelecimento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Informacaodevisita> informacaodevisitas;

	//bi-directional many-to-one association to Resenha
	@OneToMany(mappedBy="estabelecimento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Resenha> resenhas;

	public Estabelecimento() {
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getGerenteresponsavel() {
		return this.gerenteresponsavel;
	}

	public void setGerenteresponsavel(String gerenteresponsavel) {
		this.gerenteresponsavel = gerenteresponsavel;
	}

	public String getRamo() {
		return this.ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
 
	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	@XmlTransient
	public Set<Informacaodevisita> getInformacaodevisitas() {
		return this.informacaodevisitas;
	}

	public void setInformacaodevisitas(Set<Informacaodevisita> informacaodevisitas) {
		this.informacaodevisitas = informacaodevisitas;
	}

	public Informacaodevisita addInformacaodevisita(Informacaodevisita informacaodevisita) {
		getInformacaodevisitas().add(informacaodevisita);
		informacaodevisita.setEstabelecimento(this);

		return informacaodevisita;
	}

	public Informacaodevisita removeInformacaodevisita(Informacaodevisita informacaodevisita) {
		getInformacaodevisitas().remove(informacaodevisita);
		informacaodevisita.setEstabelecimento(null);

		return informacaodevisita;
	}
	@XmlTransient
	public Set<Resenha> getResenhas() {
		return this.resenhas;
	}

	public void setResenhas(Set<Resenha> resenhas) {
		this.resenhas = resenhas;
	}

	public Resenha addResenha(Resenha resenha) {
		getResenhas().add(resenha);
		resenha.setEstabelecimento(this);

		return resenha;
	}

	public Resenha removeResenha(Resenha resenha) {
		getResenhas().remove(resenha);
		resenha.setEstabelecimento(null);

		return resenha;
	}

}
package org.fs.sled.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Proprietaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProprietaire;
	private String nomProprietaire;
	private String prenomProprietaire;
	private String sexeProprietaire;
	private String adresseEmail;
	private String numeroCni;
	private String statuSocial;
	@OneToMany(mappedBy="proprietaire")
	private List<Cite> cites;
	@OneToOne(mappedBy="proprietaire")
	private Authentification authentification;
	public Proprietaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proprietaire(String nomProprietaire, String prenomProprietaire, String sexeProprietaire, String adresseEmail,
			String numeroCni, String statuSocial) {
		super();
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.sexeProprietaire = sexeProprietaire;
		this.adresseEmail = adresseEmail;
		this.numeroCni = numeroCni;
		this.statuSocial = statuSocial;
	}
	public int getIdProprietaire() {
		return idProprietaire;
	}
	public void setIdProprietaire(int idProprietaire) {
		this.idProprietaire = idProprietaire;
	}
	public String getNomProprietaire() {
		return nomProprietaire;
	}
	public void setNomProprietaire(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}
	public String getPrenomProprietaire() {
		return prenomProprietaire;
	}
	public void setPrenomProprietaire(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}
	public String getSexeProprietaire() {
		return sexeProprietaire;
	}
	public void setSexeProprietaire(String sexeProprietaire) {
		this.sexeProprietaire = sexeProprietaire;
	}
	public String getAdresseEmail() {
		return adresseEmail;
	}
	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}
	public String getNumeroCni() {
		return numeroCni;
	}
	public void setNumeroCni(String numeroCni) {
		this.numeroCni = numeroCni;
	}
	public String getStatuSocial() {
		return statuSocial;
	}
	public void setStatuSocial(String statuSocial) {
		this.statuSocial = statuSocial;
	}
	public List<Cite> getCites() {
		return cites;
	}
	public void setCites(List<Cite> cites) {
		this.cites = cites;
	}
	public Authentification getAuthentification() {
		return authentification;
	}
	public void setAuthentification(Authentification authentification) {
		this.authentification = authentification;
	}
	
}

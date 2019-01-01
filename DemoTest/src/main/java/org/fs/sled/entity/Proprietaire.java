package org.fs.sled.entity;

import java.util.Collection;

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
	private int IdProprietaire;
	private String nomProprietaire;
	private String prenomProprietaire;
	private String sexeProprietaire;
	private String adresseEmail;
	private String numeroCni;
	private String statuSocial;
	@OneToMany(mappedBy="proprietaire")
	private Collection<Cite> cites;
	@OneToOne(mappedBy="proprietaire")
	private Authentification authentification;
	public Proprietaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Proprietaire(String nomProprietaire, String prenomProprietaire, String sexeProprietaire, String adresseEmail,
			String numerocni, String statuSocial) {
		super();
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.sexeProprietaire = sexeProprietaire;
		this.adresseEmail = adresseEmail;
		this.numeroCni = numerocni;
		this.statuSocial = statuSocial;
	}
	public int getIdProprietaire() {
		return IdProprietaire;
	}
	public void setIdProprietaire(int idProprietaire) {
		IdProprietaire = idProprietaire;
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
	public String getNumerocni() {
		return numeroCni;
	}
	public void setNumerocni(String numerocni) {
		numeroCni = numerocni;
	}
	public String getStatuSocial() {
		return statuSocial;
	}
	public void setStatuSocial(String statuSocial) {
		this.statuSocial = statuSocial;
	}
	public Collection<Cite> getCites() {
		return cites;
	}
	public void setCites(Collection<Cite> cites) {
		this.cites = cites;
	}
	public Authentification getAuthentification() {
		return authentification;
	}
	public void setAuthentification(Authentification authentification) {
		this.authentification = authentification;
	}
	
}

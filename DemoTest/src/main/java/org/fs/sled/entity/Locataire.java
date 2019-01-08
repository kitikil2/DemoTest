package org.fs.sled.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Locataire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IdLocataire;
	@NotEmpty
	private String nomLocataire;
	private String prenomLocataire;
	private String sexelocataire;
	@NotEmpty
	@Email
	private String adresseEmail;
	@NotEmpty
	private String numerocni;
	private String statuSocial;
	@ManyToOne
	@JoinColumn(name="IDCITE")
	private Cite cite;
	@OneToOne
	@JoinColumn(name="IDCHAMBRE")
	private Chambre chambre;
	@OneToOne(mappedBy="locataire")
	private Authentification authentification;
	public Locataire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Locataire(String nomLocataire, String prenomLocataire, String sexelocataire, String adresseEmail,
			String numerocni, String statuSocial) {
		super();
		this.nomLocataire = nomLocataire;
		this.prenomLocataire = prenomLocataire;
		this.sexelocataire = sexelocataire;
		this.adresseEmail = adresseEmail;
		this.numerocni = numerocni;
		this.statuSocial = statuSocial;
	}
	public int getIdLocataire() {
		return IdLocataire;
	}
	public void setIdLocataire(int idLocataire) {
		IdLocataire = idLocataire;
	}
	public String getNomLocataire() {
		return nomLocataire;
	}
	public void setNomLocataire(String nomLocataire) {
		this.nomLocataire = nomLocataire;
	}
	public String getPrenomLocataire() {
		return prenomLocataire;
	}
	public void setPrenomLocataire(String prenomLocataire) {
		this.prenomLocataire = prenomLocataire;
	}
	public String getSexelocataire() {
		return sexelocataire;
	}
	public void setSexelocataire(String sexelocataire) {
		this.sexelocataire = sexelocataire;
	}
	public String getAdresseEmail() {
		return adresseEmail;
	}
	public void setAdresseEmail(String adresseEmail) {
		this.adresseEmail = adresseEmail;
	}
	public String getNumerocni() {
		return numerocni;
	}
	public void setNumerocni(String numerocni) {
		this.numerocni = numerocni;
	}
	public String getStatuSocial() {
		return statuSocial;
	}
	public void setStatuSocial(String statuSocial) {
		this.statuSocial = statuSocial;
	}
	public Cite getCite() {
		return cite;
	}
	public void setCite(Cite cite) {
		this.cite = cite;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	public Authentification getAuthentification() {
		return authentification;
	}
	public void setAuthentification(Authentification authentification) {
		this.authentification = authentification;
	}
	
}

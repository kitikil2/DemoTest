package org.fs.sled.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class ProprietaireForm {
	@NotEmpty
	private String nomProprietaire;
	private String prenomProprietaire;
	private String sexeProprietaire;
	@Email
	private String adresseEmail;
	@NotEmpty
	private String numeroCni;
	private String statuSocial;
	@NotBlank
	private String login;
	@Size(min = 6, max = 30)
	private String password;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

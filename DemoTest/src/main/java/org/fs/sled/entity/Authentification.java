package org.fs.sled.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Authentification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAuthenti;
	@NotEmpty
	private String login;
	@NotEmpty
	private String password;
	@OneToOne
	@JoinColumn(name="IDPROPRIE")
	private Proprietaire proprietaire;
	@OneToOne
	@JoinColumn(name="IDLOCA")
	private Locataire locataire;
	public Authentification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Authentification(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public int getIdAuthenti() {
		return idAuthenti;
	}
	public void setIdAuthenti(int idAuthenti) {
		this.idAuthenti = idAuthenti;
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
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Locataire getLocataire() {
		return locataire;
	}
	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}
	
	
	

}

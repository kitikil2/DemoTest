package org.fs.sled.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Cite {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCite;
	@NotEmpty
	private String nomCite;
	private int nombreChambre;
	@NotEmpty
	private String descriptionCite;
	private String photo;
	@ManyToOne
	@JoinColumn(name="IDPROPRIETAIRE")
	private Proprietaire proprietaire;
	@OneToMany(mappedBy="cite")
	private List<Locataire> locataires;
	@OneToMany(mappedBy="cite")
	private List<Chambre> chambres;
	@ManyToOne
	@JoinColumn(name="IDPOSSITION")
	private Possition possition;
	public Cite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cite(String nomCite, int nombreChambre, String descriptionCite, String photo) {
		super();
		this.nomCite = nomCite;
		this.nombreChambre = nombreChambre;
		this.descriptionCite = descriptionCite;
		this.photo = photo;
	}
	public int getIdCite() {
		return idCite;
	}
	public void setIdCite(int idCite) {
		this.idCite = idCite;
	}
	public String getNomCite() {
		return nomCite;
	}
	public void setNomCite(String nomCite) {
		this.nomCite = nomCite;
	}
	public int getNombreChambre() {
		return nombreChambre;
	}
	public void setNombreChambre(int nombreChambre) {
		this.nombreChambre = nombreChambre;
	}
	public String getDescriptionCite() {
		return descriptionCite;
	}
	public void setDescriptionCite(String descriptionCite) {
		this.descriptionCite = descriptionCite;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Proprietaire getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}
	public List<Locataire> getLocataires() {
		return locataires;
	}
	public void setLocataires(List<Locataire> locataires) {
		this.locataires = locataires;
	}
	public List<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	public Possition getPossition() {
		return possition;
	}
	public void setPossition(Possition possition) {
		this.possition = possition;
	}
	
}

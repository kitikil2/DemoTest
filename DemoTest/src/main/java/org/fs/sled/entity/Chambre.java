package org.fs.sled.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Chambre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idChambre;
	@NotEmpty
	private String nomchambre;
	private float prix;
	@ManyToOne
	@JoinColumn(name="IDCATEGORIE")
	private CategorieChambre categorie;
	private String photos;
	@ManyToOne
	@JoinColumn(name="IDCITE")
	private Cite cite;
	@OneToOne(mappedBy="chambre")
	private Locataire locataire;
	public int getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(int idChambre) {
		this.idChambre = idChambre;
	}
	public String getNomchambre() {
		return nomchambre;
	}
	public void setNomchambre(String nomchambre) {
		this.nomchambre = nomchambre;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public CategorieChambre getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieChambre categorie) {
		this.categorie = categorie;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public Cite getCite() {
		return cite;
	}
	public void setCite(Cite cite) {
		this.cite = cite;
	}
	public Locataire getLocataire() {
		return locataire;
	}
	public void setLocataire(Locataire locataire) {
		this.locataire = locataire;
	}
	public Chambre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chambre(String nomchambre, float prix, String photos) {
		super();
		this.nomchambre = nomchambre;
		this.prix = prix;
		this.photos = photos;
	}
	
}

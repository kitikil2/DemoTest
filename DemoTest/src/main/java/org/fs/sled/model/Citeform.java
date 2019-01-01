package org.fs.sled.model;

import java.util.Collection;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.fs.sled.entity.Chambre;
import org.fs.sled.entity.Locataire;
import org.fs.sled.entity.Possition;
import org.fs.sled.entity.Proprietaire;
import org.hibernate.validator.constraints.NotEmpty;

public class Citeform {
	@NotEmpty
	private String nomCite;
	private int nombreChambre;
	@NotEmpty
	private String descriptionCite;
	private String photo;
	private Proprietaire proprietaire;
	private Chambre chambres;
	private Possition possition;
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
	public Chambre getChambres() {
		return chambres;
	}
	public void setChambres(Chambre chambres) {
		this.chambres = chambres;
	}
	public Possition getPossition() {
		return possition;
	}
	public void setPossition(Possition possition) {
		this.possition = possition;
	}

}

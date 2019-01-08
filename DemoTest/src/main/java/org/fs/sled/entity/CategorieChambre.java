package org.fs.sled.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class CategorieChambre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCategorie;
	@NotEmpty
	private String description;
	@NotEmpty
	private String typeCategorie;
	@OneToMany(mappedBy="categorie")
	private List<Chambre> chambres;
	public CategorieChambre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategorieChambre(String description, String typeCategorie) {
		super();
		this.description = description;
		this.typeCategorie = typeCategorie;
	}
	public int getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTypeCategorie() {
		return typeCategorie;
	}
	public void setTypeCategorie(String typeCategorie) {
		this.typeCategorie = typeCategorie;
	}
	public List<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
}

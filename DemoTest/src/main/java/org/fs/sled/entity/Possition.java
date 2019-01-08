package org.fs.sled.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Possition {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpossition;
	private String quartier;
	private float distince;
	@OneToMany(mappedBy="possition")
	private List<Cite> cites;
	public Possition() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Possition(String quartier, float distince) {
		super();
		this.quartier = quartier;
		this.distince = distince;
	}
	public int getIdpossition() {
		return idpossition;
	}
	public void setIdpossition(int idpossition) {
		this.idpossition = idpossition;
	}
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public float getDistince() {
		return distince;
	}
	public void setDistince(float distince) {
		this.distince = distince;
	}
	public List<Cite> getCites() {
		return cites;
	}
	public void setCites(List<Cite> cites) {
		this.cites = cites;
	}
	
}

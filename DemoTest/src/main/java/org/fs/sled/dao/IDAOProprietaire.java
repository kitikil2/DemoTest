package org.fs.sled.dao;

import java.util.List;

import org.fs.sled.entity.Authentification;
import org.fs.sled.entity.CategorieChambre;
import org.fs.sled.entity.Chambre;
import org.fs.sled.entity.Cite;
import org.fs.sled.entity.Possition;
import org.fs.sled.entity.Proprietaire;



public interface IDAOProprietaire {
	public Proprietaire addprop(Proprietaire p);
	public void updateProp(Proprietaire p);
	public void delete(int idProp);
	public int getProprietaire(String numCNI,String nomP);
	public Proprietaire getProprietaire(int idprop);
	
	public void addPassword(Authentification a,int idProp);
	public void updatePassword(int idAuthent);
	public Proprietaire findCompte(String login,String pass);
	
	public int addCite(Cite ci,int idPoss);
	public Cite updateCite(Cite ci);
	public Cite findCite(String nomCite);
	public Cite getCite(int idCite);
	public List<Cite> listeCite(int idpro);
	public List<Cite> listeCite();
	
	public void addChambre(Chambre ch,int idCite);
	public Chambre updateChambre(Chambre ch);
	public void deleteChambre(int idChambre);
	public List<Chambre> listchambre(int idcite);
	public void modifierchambre(Chambre ch);
	
	public Possition addPossit(Possition po);
	public void update(int idPoss);
	public List<Possition> listPoss();
	
	public CategorieChambre addCategorie(CategorieChambre ca);
	public List<CategorieChambre> listecategorie();
	public CategorieChambre getcategorie(int idcat);
	

}
package org.fs.sled.metier;

import java.util.List;

import org.fs.sled.entity.Authentification;
import org.fs.sled.entity.CategorieChambre;
import org.fs.sled.entity.Chambre;
import org.fs.sled.entity.Cite;
import org.fs.sled.entity.Locataire;
import org.fs.sled.entity.Possition;
import org.fs.sled.entity.Proprietaire;


public interface IMetier {
	public Proprietaire addprop(Proprietaire p);
	public void updateProp(Proprietaire p);
	public void delete(int idProp);
	public int getProprietaire(String numCNI,String nomP);
	public Proprietaire getProprietaire(int idprop);
	public List<Proprietaire> getProprietaire(String numcni);
	
	public void addPassword(Authentification a,int idProp);
	public void updatePassword(int idAuthent);
	public Proprietaire findCompte(String login,String pass);
	public Locataire findComptelocataire(String login,String pass);

	
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
	public Chambre getchambre(int idchambre);
	
	public Possition addPossit(Possition po);
	public void update(int idPoss);
	public List<Possition> listPoss();
	
	public CategorieChambre addCategorie(CategorieChambre ca);
	public List<CategorieChambre> listecategorie();
	public CategorieChambre getcategorie(int idcat);
	
	public Locataire addLocataire(Locataire l);
	public Locataire updatelocataire(Locataire l);
	public Locataire getlocataire(int idloca);
	public List<Locataire> getlocataire(String numcni);
	
}

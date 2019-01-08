package org.fs.sled.metier;

import java.util.List;

import org.fs.sled.dao.IDAOProprietaire;
import org.fs.sled.entity.Authentification;
import org.fs.sled.entity.CategorieChambre;
import org.fs.sled.entity.Chambre;
import org.fs.sled.entity.Cite;
import org.fs.sled.entity.Locataire;
import org.fs.sled.entity.Possition;
import org.fs.sled.entity.Proprietaire;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class ImplMetier implements IMetier{
	private IDAOProprietaire dao;
	public void setDao(IDAOProprietaire dao) {
		this.dao = dao;
	}

	@Override
	public Proprietaire addprop(Proprietaire p) {
		return dao.addprop(p);
	}

	@Override
	public void updateProp(Proprietaire p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idProp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getProprietaire(String numCNI, String nomP) {
		// TODO Auto-generated method stub
		return dao.getProprietaire(numCNI, nomP);
	}

	@Override
	public void addPassword(Authentification a, int idProp) {
		dao.addPassword(a, idProp);
	}

	@Override
	public void updatePassword(int idAuthent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addCite(Cite ci, int idPoss) {
		return dao.addCite(ci, idPoss);
	}

	@Override
	public Cite updateCite(Cite ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cite findCite(String nomCite) {
		return dao.findCite(nomCite);
	}

	@Override
	public void addChambre(Chambre ch, int idCite) {
		dao.addChambre(ch, idCite);
	}

	@Override
	public Chambre updateChambre(Chambre ch) {
		return dao.updateChambre(ch);
	}

	@Override
	public void deleteChambre(int idChambre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Possition addPossit(Possition po) {
		return dao.addPossit(po);
	}

	@Override
	public void update(int idPoss) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Possition> listPoss() {
		return dao.listPoss();
	}

	@Override
	public CategorieChambre addCategorie(CategorieChambre ca) {
		return dao.addCategorie(ca);
	}

	@Override
	public Proprietaire findCompte(String login, String pass) {
		return dao.findCompte(login, pass);
	}

	@Override
	public List<CategorieChambre> listecategorie() {
		// TODO Auto-generated method stub
		return dao.listecategorie();
	}

	@Override
	public Cite getCite(int idCite) {
		return dao.getCite(idCite);
	}

	@Override
	public Proprietaire getProprietaire(int idprop) {
		return dao.getProprietaire(idprop);
	}

	@Override
	public List<Cite> listeCite(int idpro) {
		// TODO Auto-generated method stub
		return dao.listeCite(idpro);
	}

	@Override
	public List<Chambre> listchambre(int idcite) {
		// TODO Auto-generated method stub
		return dao.listchambre(idcite);
	}

	@Override
	public void modifierchambre(Chambre ch) {
		dao.modifierchambre(ch);
	}

	@Override
	public CategorieChambre getcategorie(int idcat) {
		return dao.getcategorie(idcat);
	}

	@Override
	public List<Cite> listeCite() {
		return dao.listeCite();
	}

	@Override
	public Chambre getchambre(int idchambre) {
		return dao.getchambre(idchambre);
	}

	@Override
	public List<Proprietaire> getProprietaire(String numcni) {
		return dao.getProprietaire(numcni);
	}

	@Override
	public Locataire addLocataire(Locataire l) {
		return dao.addLocataire(l);
	}

	@Override
	public Locataire updatelocataire(Locataire l) {
		return dao.updatelocataire(l);
	}

	@Override
	public Locataire getlocataire(int idloca) {
		return dao.getlocataire(idloca);
	}

	@Override
	public List<Locataire> getlocataire(String numcni) {
		return dao.getlocataire(numcni);
	}

	@Override
	public Locataire findComptelocataire(String login, String pass) {
		return dao.findComptelocataire(login, pass);
	}

}

package org.fs.sled.dao;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Query;

import org.fs.sled.entity.Authentification;
import org.fs.sled.entity.CategorieChambre;
import org.fs.sled.entity.Chambre;
import org.fs.sled.entity.Cite;
import org.fs.sled.entity.Locataire;
import org.fs.sled.entity.Possition;
import org.fs.sled.entity.Proprietaire;



public class ImplDAOProprietaire implements IDAOProprietaire {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Proprietaire addprop(Proprietaire p) {
		em.persist(p);
		return p;
	}

	@Override
	public void updateProp(Proprietaire p) {
		em.merge(p);
	}

	@Override
	public void delete(int idProp) {
		Proprietaire p=em.find(Proprietaire.class, idProp);
		em.remove(p);
	}

	@Override
	public int getProprietaire(String numCNI, String nomP) {
		Query req=em.createQuery("select p from Proprietaire p where p.Numerocni=:numcni and p.nomProprietaire=:nomp");
		req.setParameter("numcni",numCNI);
		req.setParameter("nomp", nomP);
		Proprietaire p=(Proprietaire) req.getSingleResult();
		return p.getIdProprietaire();
	}

	@Override
	public void addPassword(Authentification a, int idProp) {
		Proprietaire p=em.find(Proprietaire.class, idProp);
		a.setProprietaire(p);
		em.persist(a);
	}

	@Override
	public void updatePassword(int idAuthent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addCite(Cite ci, int idPoss) {
		Possition pos=em.find(Possition.class, idPoss);
		ci.setPossition(pos);
		em.persist(ci);
		return ci.getIdCite();
	}

	@Override
	public Cite updateCite(Cite ci) {
		em.merge(ci);
		return ci;
	}

	@Override
	public void addChambre(Chambre ch, int idCite) {
		Cite ci=em.find(Cite.class, idCite);
		ch.setCite(ci);
		em.persist(ch);
	}

	@Override
	public Chambre updateChambre(Chambre ch) {
		
		return null;
	}

	@Override
	public void deleteChambre(int idChambre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Possition addPossit(Possition po) {
		em.persist(po);
		return po;
	}

	@Override
	public void update(int idPoss) {
		
	}

	@Override
	public List<Possition> listPoss() {
		Query req=em.createQuery("select p from Possition p");
		return req.getResultList();
	}

	@Override
	public CategorieChambre addCategorie(CategorieChambre ca) {
		em.persist(ca);
		return ca;
	}

	@Override
	public Cite findCite(String nomCite) {
		Query req=em.createQuery("select ci from Cite ci where ci.nomCite like :x");
		req.setParameter("x","%"+nomCite+"%");
		return (Cite) req.getSingleResult();
	}

	@Override
	public Proprietaire findCompte(String login, String pass) {
		Query req=em.createQuery("select au from Authentification au where au.login=:login and au.password=:pass");
		req.setParameter("login",login);
		req.setParameter("pass", pass);
		Authentification au=(Authentification) req.getSingleResult();
		return au.getProprietaire();
	}

	@Override
	public List<CategorieChambre> listecategorie() {
		Query req=em.createQuery("select cat from CategorieChambre cat");
		return req.getResultList();
	}

	@Override
	public Cite getCite(int idCite) {
		Query req=em.createQuery("select ci from Cite ci where ci.idCite =:x");
		req.setParameter("x",idCite);
		return (Cite) req.getSingleResult();
	}

	@Override
	public Proprietaire getProprietaire(int idprop) {
		Query req=em.createQuery("select p from Proprietaire p where p.idProprietaire=:idprop");
		req.setParameter("idprop",idprop);
		return (Proprietaire) req.getSingleResult();
	}

	@Override
	public List<Cite> listeCite(int idpro) {
		Query req=em.createQuery("select ci from Cite ci where ci.proprietaire.idProprietaire=:idprop");
		req.setParameter("idprop",idpro);
		return req.getResultList();
	}

	@Override
	public List<Chambre> listchambre(int idcite) {
		Query req=em.createQuery("select ch from Chambre ch where ch.cite.idCite=:idcite");
		req.setParameter("idcite",idcite);
		return req.getResultList();
	}

	@Override
	public void modifierchambre(Chambre ch) {
		em.merge(ch);
	}

	@Override
	public CategorieChambre getcategorie(int idcat) {
		return em.find(CategorieChambre.class, idcat);
	}

	@Override
	public List<Cite> listeCite() {
		Query req=em.createQuery("select ci from Cite ci");
		return req.getResultList();
	}

	@Override
	public Chambre getchambre(int idchambre) {
		Chambre ch=em.find(Chambre.class, idchambre);
		return ch;
	}

	@Override
	public List<Proprietaire> getProprietaire(String numcni) {
		Query req=em.createQuery("select p from Proprietaire p where p.numeroCni=:idprop");
		req.setParameter("idprop",numcni);
		return  req.getResultList();
	}

	@Override
	public Locataire getlocataire(int idloca) {
		Query req=em.createQuery("select l from Locataire l where l.IdLocataire=:idprop");
		req.setParameter("idprop",idloca);
		return  (Locataire) req.getSingleResult();
	}

	@Override
	public Locataire addLocataire(Locataire l) {
		em.persist(l);
		return l;
	}

	@Override
	public Locataire updatelocataire(Locataire l) {
		em.merge(l);
		return l;
	}

	@Override
	public List<Locataire> getlocataire(String numcni) {
		Query req=em.createQuery("select l from Locataire l where l.Numerocni=:idprop");
		req.setParameter("idprop",numcni);
		return  req.getResultList();
	}

	@Override
	public Locataire findComptelocataire(String login, String pass) {
		Query req=em.createQuery("select au from Authentification au where au.login=:login and au.password=:pass");
		req.setParameter("login",login);
		req.setParameter("pass", pass);
		Authentification au=(Authentification) req.getSingleResult();
		return au.getLocataire();
	}

}

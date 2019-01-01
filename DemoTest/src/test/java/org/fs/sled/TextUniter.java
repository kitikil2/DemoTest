package org.fs.sled;

import static org.junit.Assert.*;

import java.util.List;

import org.fs.sled.entity.Authentification;
import org.fs.sled.entity.CategorieChambre;
import org.fs.sled.entity.Chambre;
import org.fs.sled.entity.Cite;
import org.fs.sled.entity.Possition;
import org.fs.sled.entity.Proprietaire;
import org.fs.sled.metier.IMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TextUniter {
	@Test
	public void test() {
	try {
	ClassPathXmlApplicationContext app=
	new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
	IMetier metier=(IMetier) app.getBean("metier");
	System.out.println("Ajouter la possition ------------------------");
	/*Possition po1=metier.addPossit(new Possition("BINI", 1));
	Possition po2=metier.addPossit(new Possition("DANG", 2));
	System.out.println("le quartier est :" +po1.getIdpossition()+"---"+po1.getQuartier());
	System.out.println("Ajouter proprietaire ------------------------");
	Proprietaire pr1=metier.addprop(new Proprietaire("aziz", "kitikil", "m", "kitikil@gmail.com", "1234", "celiba"));
	Proprietaire pr2=metier.addprop(new Proprietaire("mousa", "django", "m", "django@gmail.com", "1278", "mari"));
	Proprietaire pr3=metier.addprop(new Proprietaire("sali", "haman", "m", "sali@gmail.com", "1209", "celiba"));
	Proprietaire pr4=metier.addprop(new Proprietaire("mamma", "carote", "f", "mamma@gmail.com", "1289", "celiba"));
	System.out.println("Rechercher et Ajouter d'autentification ------------------------");
	*/
	/*int pr5=metier.getProprietaire("1289", "mamma");
	System.out.println(pr5);
	metier.addPassword(new Authentification("mamma", "mamma"), pr5);
	
	System.out.println("liste la possition ------------------------");
	List<Possition> pos=metier.listPoss();
	for (Possition possition : pos) {
		System.out.println(possition.getQuartier());
	}*/
	System.out.println("Ajouter une categorie ------------------------");
	metier.addCategorie(new CategorieChambre("Npn Equipe", "VIP"));
	System.out.println("Ajouter une cite et les chambres de la cite ------------------------");
	int idci=metier.addCite(new Cite("Cite fermat3", 5, "hjf", null), 1);
	System.out.println("Id cite "+ idci);
	Chambre ch=new Chambre("CE", 14000, "chd");
	for (int i = 0; i < 6; i++) {
		metier.addChambre(new Chambre(ch.getNomchambre()+(i+1), ch.getPrix(), null), idci);
	}
	
	
	Proprietaire p=metier.findCompte("kitikil", "kitikil");
	System.out.println(p.getAdresseEmail());
	List<CategorieChambre> cat=metier.listecategorie();
	for (CategorieChambre cate : cat) {
		System.out.println(cate.getDescription());
	}
	Cite ci=metier.getCite(1);
	System.out.println(ci.getNomCite());
	Proprietaire pro=metier.getProprietaire(2);
	System.out.println(pro.getNomProprietaire()+"-------------------------");
	List<Cite> cites=metier.listeCite(7);
	for (Cite c : cites) {
		System.out.println(c.getDescriptionCite());
	}
	List<Chambre> chs=metier.listchambre(4);
	if (chs.isEmpty()) {
		System.out.println("la liste est vide");
	}
	
	assertTrue(true);
	} catch (Exception e) {
	assertTrue(e.getMessage(),false);
	} }
}

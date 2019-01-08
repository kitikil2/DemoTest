package org.fs.sled;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.fs.sled.entity.Authentification;
import org.fs.sled.entity.Chambre;
import org.fs.sled.entity.Cite;
import org.fs.sled.entity.Locataire;
import org.fs.sled.entity.Proprietaire;
import org.fs.sled.metier.IMetier;
import org.fs.sled.model.ProprietaireForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("chambre")
public class HomeController {
	
	@Autowired
	private IMetier metier;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		model.addAttribute("indix", "listecite");
		model.addAttribute("logins", new Authentification());
		model.addAttribute("listecite",metier.listeCite());
		return "clientLo";
	}
	
	@RequestMapping(value="/client/visitechambre")
	public String visiteclient(@RequestParam int idcite, Model model){
		List<Chambre> chs=metier.listchambre(idcite);
		List<Chambre> chams=new ArrayList<Chambre>();
		for (Chambre cha : chs) {
			if (cha.getLocataire()==null) {
				if (cha.getCategorie()!=null) {
					chams.add(cha);
				}
			}
		}
		model.addAttribute("logins", new Authentification());
		model.addAttribute("indix", "listechambre");
		model.addAttribute("cite", metier.getCite(idcite));
		model.addAttribute("listechambre", chams);
		return "clientLo";
	}
	@RequestMapping(value="/services/cite")
	public String servicecite(Model model) {
		model.addAttribute("indix", "listecite");
		model.addAttribute("logins", new Authentification());
		model.addAttribute("listecite",metier.listeCite());
		return "clietLo";
	}
	
	@RequestMapping(value="/client/reservechambre")
	public String reservechambre(@RequestParam(value="idchambre") int idchambre, Model model) {
		model.addAttribute("logins", new Authentification());
		model.addAttribute("chambre", metier.getchambre(idchambre));
		model.addAttribute("proprietaire", new ProprietaireForm());
		model.addAttribute("indix", "creercompte");
		return "clientLo";
	}
	
	@RequestMapping(value="/client/saveclient" ,method=RequestMethod.POST)
	public String  saveclient(@ModelAttribute("proprietaire") @Valid ProprietaireForm pf,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("logins", new Authentification());
			model.addAttribute("chambre", model.asMap().get("chambre"));
			model.addAttribute("indix", "creercompte");
			return "clientLo";
		}
		
		List<Locataire> ps=metier.getlocataire(pf.getNumeroCni());
		if (!ps.isEmpty()) {
			model.addAttribute("erreur", "Votre numero de CNI existe ");
			model.addAttribute("locataire", pf);
			model.addAttribute("logins", new Authentification());
			model.addAttribute("indix", "creercompte");
		    return "clientLo";
		}else {
			Locataire p=metier.addLocataire(new Locataire(pf.getNomProprietaire(),
					pf.getPrenomProprietaire(), pf.getSexeProprietaire(), pf.getAdresseEmail(),
					pf.getNumeroCni(),pf.getStatuSocial()));
			Chambre cha=(Chambre) model.asMap().get("chambre");
			System.out.println(cha.getNomchambre());
			p.setChambre(cha);
			metier.updatelocataire(p);
			Authentification au= new Authentification(pf.getLogin(), pf.getPassword());
			au.setLocataire(p);
		    metier.addPassword(au,0);
		    model.addAttribute("chambre", p);
		    model.addAttribute("indix", "accueil");
		    model.addAttribute("locataire", model.asMap().get("chambre"));
		    Locataire loca=(Locataire) model.asMap().get("chambre");
		    Chambre ch=loca.getChambre();
		    Proprietaire pro=ch.getCite().getProprietaire();
		    model.addAttribute("proprio", pro);
		}
		
		return "accueilCli";
	}
	
	@RequestMapping(value="/client/logins")
	public String login(@ModelAttribute("logins") @Valid Authentification au,BindingResult bindingResult,Model model){
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("indix", "listecite");
			model.addAttribute("listecite",metier.listeCite());
			return "clientLo";
		}
		Locataire loc=metier.findComptelocataire(au.getLogin(), au.getPassword());
		if (loc==null) {
			model.addAttribute("logins", new Authentification());
			model.addAttribute("indix", "listecite");
			model.addAttribute("listecite",metier.listeCite());
			return "clientLo";
		}
		model.addAttribute("indix", "accueil");
		Chambre ch=loc.getChambre();
		Cite ci=ch.getCite();
		Proprietaire pro=ci.getProprietaire();
		 model.addAttribute("locataire", loc);
		model.addAttribute("indique", "listecite");
		model.addAttribute("chambre", pro);
		model.addAttribute("cite", ci);
		model.addAttribute("chamb", ch);
		model.addAttribute("proprio", pro);
		
		return "accueilCli";
	}
}

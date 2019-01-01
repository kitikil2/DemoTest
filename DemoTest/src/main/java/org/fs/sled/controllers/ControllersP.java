package org.fs.sled.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.fs.sled.entity.Authentification;
import org.fs.sled.entity.CategorieChambre;
import org.fs.sled.entity.Chambre;
import org.fs.sled.entity.Cite;
import org.fs.sled.entity.Possition;
import org.fs.sled.entity.Proprietaire;
import org.fs.sled.metier.IMetier;
import org.fs.sled.model.ProprietaireForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("proprietaires")
public class ControllersP {
	@Autowired
	private IMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("login", new Authentification());
		model.addAttribute("proprietaire", new ProprietaireForm());
		return "index";
	}
	
	@RequestMapping(value="/saveProp")
	public String saveprop(ProprietaireForm pf,Model model){
	     if (!pf.getNomProprietaire().isEmpty()) {
			if (!pf.getPrenomProprietaire().isEmpty()) {
				if (!pf.getLogin().isEmpty()) {
					if (!pf.getNumeroCni().isEmpty()) {
						if (!pf.getPassword().isEmpty()) {
							if (!pf.getAdresseEmail().isEmpty()) {
								Proprietaire p=metier.addprop(new Proprietaire(pf.getNomProprietaire(),
										pf.getPrenomProprietaire(), pf.getSexeProprietaire(), pf.getAdresseEmail(),
										pf.getNumeroCni(),pf.getStatuSocial()));
							    metier.addPassword(new Authentification(pf.getLogin(), pf.getPassword()), p.getIdProprietaire());
							    model.addAttribute("proprietaires", p);
							    model.addAttribute("proprio", model.asMap().get("proprietaires"));
							} else {
								model.addAttribute("proprietaire", new ProprietaireForm());
                                model.addAttribute("erreur", "Le mail ne doit pas etre vide"); 
                                return "index";
							}
						} else {
							model.addAttribute("proprietaire", new ProprietaireForm());
							model.addAttribute("erreur", "Le mot de passe ne doit pas etre vide"); 
							return "index";
						}
					} else {
						model.addAttribute("proprietaire", new ProprietaireForm());
						model.addAttribute("erreur", "Le numero de votre cate national ne dooit pas etre vide");
						return "index";
					}
				} else {
					model.addAttribute("proprietaire", new ProprietaireForm());
					model.addAttribute("erreur", "Le login ne doit pas etre vide");
					return "index";
				}
			}
		}else {
			model.addAttribute("proprietaire", new ProprietaireForm());
			model.addAttribute("erreur", "Le nom ne doit pas etre vide"); 
			return "index";
		}
		return "accueil";
	}
	
	@RequestMapping(value="/login")
	public String login(Authentification au,Model model) {
		if (au.getLogin().isEmpty()||au.getPassword().isEmpty()) {
			model.addAttribute("login", new Authentification());
			model.addAttribute("proprietaire", new ProprietaireForm());
			return "index";
		}
		Proprietaire p=metier.findCompte(au.getLogin(), au.getPassword());
		if (p==null) {
			model.addAttribute("login", new Authentification());
			model.addAttribute("proprietaire", new ProprietaireForm());
			return "index";
		}
		List<Cite> ci=metier.listeCite(p.getIdProprietaire());
		if (ci.isEmpty()) {
			model.addAttribute("possition", metier.listPoss());
			model.addAttribute("cite", new Cite());
			model.addAttribute("proprietaires", p);
			model.addAttribute("proprio", model.asMap().get("proprietaires"));
			return "accueil";
		}
		model.addAttribute("indique", "listecite");
		model.addAttribute("chambre", new Chambre());
		model.addAttribute("proprietaires", p);
		model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()) );
		
		return "categorie";
	}
	
	@RequestMapping(value="/savecite")
	public String savecite(@Valid Cite c,BindingResult bindingResult,Model model,MultipartFile file) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("possition", metier.listPoss());
			model.addAttribute("cite", new Cite());
			model.addAttribute("proprio", model.asMap().get("proprietaires"));
			return "accueil";
		}
		if (!file.isEmpty()) {
			String path=System.getProperty("java.io.tmpdir");
			c.setPhoto(file.getOriginalFilename());
			Proprietaire po=(Proprietaire) model.asMap().get("proprietaires");
			c.setProprietaire(po);
			int idci=metier.addCite(c, c.getPossition().getIdpossition());
			file.transferTo(new File(path+"/CITE_"+idci+"_"+file.getOriginalFilename()));
			model.addAttribute("cites",po );
		}else {
			
			Proprietaire po=(Proprietaire) model.asMap().get("proprietaires");
			c.setProprietaire(po);
			metier.addCite(c, c.getPossition().getIdpossition());
			Proprietaire pro=metier.getProprietaire(po.getIdProprietaire());
			model.addAttribute("proprietaires", pro);
			model.addAttribute("cites",pro );
		}
		model.addAttribute("proprio", model.asMap().get("proprietaires"));
		return "categorie";
	}
	
	@RequestMapping(value="/photoci",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[]  photocite(int idCite) throws IOException {
		Cite ci=metier.getCite(idCite);
		File f=new File(System.getProperty("java.io.tmpdir")+"/CITE_"+idCite+"_"+ci.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
		
	}
	
	@RequestMapping(value="/configue")
    public String gestion(int idcite,Model model) {
		model.addAttribute("chambre", new Chambre());
		model.addAttribute("config", "congif");
		model.addAttribute("indique", "listecite");
		model.addAttribute("singlcite", metier.getCite(idcite));
	    Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
		model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()));
		
		return "categorie";
		
	}
	
    @RequestMapping(value="/addchambre")
	public String gestionchambre(Chambre ch,Model model) {
		Cite ci=metier.getCite(ch.getCite().getIdCite());
		for (int i = 0; i < ci.getNombreChambre(); i++) {
			metier.addChambre(new Chambre(ch.getNomchambre()+(i+1), ch.getPrix(), null), ch.getCite().getIdCite());
		}
		model.addAttribute("config", "su");
		model.addAttribute("indique", "listecite");
		Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
	    model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()));
		return "categorie";
		
	}
    
    @RequestMapping(value="/configuechambre")
    public String  configuechambre(int idcite,Model model) {
    	model.addAttribute("indique", "listechambre");
    	
    	model.addAttribute("chambre", new Chambre());
    	model.addAttribute("listechambre", metier.listchambre(idcite));
    	model.addAttribute("listecategorie", metier.listecategorie());
    	model.addAttribute("singlcite", metier.getCite(idcite));
    	
		Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
	    model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()));
		return "categorie";
	}
    
    @RequestMapping(value="/modifierchambre")
    public String  listecite(Chambre ch,Model model) {
        model.addAttribute("indique", "listechambre");
        
        CategorieChambre cate=metier.getcategorie(ch.getCategorie().getIdCategorie());
        ch.setCategorie(cate);
        
    	metier.modifierchambre(ch);
    	model.addAttribute("chambre", new Chambre());
    	model.addAttribute("listechambre", metier.listchambre(ch.getCite().getIdCite()));
    	model.addAttribute("listecategorie", metier.listecategorie());
    	model.addAttribute("singlcite", metier.getCite(ch.getCite().getIdCite()));
    	
		Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
	    model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()));
    	
    	
		return "categorie";
	}
}

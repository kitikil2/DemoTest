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
import org.fs.sled.entity.Proprietaire;
import org.fs.sled.metier.IMetier;
import org.fs.sled.model.ProprietaireForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		model.addAttribute("logins", new Authentification());
		model.addAttribute("proprietaire", new ProprietaireForm());
		return "index";
	}
	
	@RequestMapping(value="/saveProp" , method=RequestMethod.POST)
	public String saveprop(@ModelAttribute("proprietaire")  @Valid ProprietaireForm pf,BindingResult bindingResult,
			Model model) throws IOException{
		if (bindingResult.hasErrors()) {
					model.addAttribute("logins", new Authentification());
				    return "index";
				}
		List<Proprietaire> ps=metier.getProprietaire(pf.getNumeroCni());
		if (ps!=null) {
			model.addAttribute("erreur", "Verifier votre numero de CNI");
			model.addAttribute("proprios", pf);
			model.addAttribute("logins", new Authentification());
		    return "index";
		}else {
			Proprietaire p=metier.addprop(new Proprietaire(pf.getNomProprietaire(),
					pf.getPrenomProprietaire(), pf.getSexeProprietaire(), pf.getAdresseEmail(),
					pf.getNumeroCni(),pf.getStatuSocial()));
		    metier.addPassword(new Authentification(pf.getLogin(), pf.getPassword()), p.getIdProprietaire());
		    model.addAttribute("proprietaires", p);
		    model.addAttribute("notification", metier.notification(p));
		    model.addAttribute("cite", new Cite());
		    model.addAttribute("proprio", model.asMap().get("proprietaires"));
		}
		return "accueil";
	}
	
	@RequestMapping(value="/logins", method=RequestMethod.POST)
	public String login(@ModelAttribute("logins") @Valid Authentification au, BindingResult bindingResult,Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("proprietaire", new ProprietaireForm());
			return "index";
		}
		
		Proprietaire p=metier.findCompte(au.getLogin(), au.getPassword());
		if (p==null) {
			model.addAttribute("logins", new Authentification());
			model.addAttribute("proprietaire", new ProprietaireForm());
			return "index";
		}
		List<Cite> ci=metier.listeCite(p.getIdProprietaire());
		if (ci.isEmpty()) {
			model.addAttribute("possition", metier.listPoss());
			model.addAttribute("cite", new Cite());
			model.addAttribute("proprietaires", p);
			model.addAttribute("notification", metier.notification(p));
			model.addAttribute("proprio", model.asMap().get("proprietaires"));
			return "accueil";
		}
		model.addAttribute("indique", "listecite");
		model.addAttribute("chambre", new Chambre());
		model.addAttribute("proprietaires", p);
		model.addAttribute("notification", metier.notification(p));
		model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()) );
		
		return "categorie";
	}
	
	@RequestMapping(value="/savecite")
	public String savecite(@Valid Cite c,BindingResult bindingResult,Model model,MultipartFile file) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("possition", metier.listPoss());
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
		Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
		model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("notification", metier.notification(p));
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
	    model.addAttribute("notification", metier.notification(p));
		model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()));
		
		return "categorie";
		
	}
	
    @RequestMapping(value="/addchambre")
	public String gestionchambre(@Valid Chambre ch,BindingResult bindingResult,Model model) {
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("config", "congif");
    		model.addAttribute("indique", "listecite");
    		model.addAttribute("singlcite", metier.getCite(ch.getCite().getIdCite()));
    	    Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
    	    model.addAttribute("notification", metier.notification(p));
    		model.addAttribute("proprio", model.asMap().get("proprietaires"));
    		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()));
    		return "categorie";
		}
		Cite ci=metier.getCite(ch.getCite().getIdCite());
		for (int i = 0; i < ci.getNombreChambre(); i++) {
			metier.addChambre(new Chambre(ch.getNomchambre()+(i+1), ch.getPrix(), null), ch.getCite().getIdCite());
		}
		model.addAttribute("config", "su");
		model.addAttribute("indique", "listecite");
		Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
		model.addAttribute("notification", metier.notification(p));
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
		model.addAttribute("notification", metier.notification(p));
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
		model.addAttribute("notification", metier.notification(p));
	    model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()));
    	return "categorie";
	}
    
    @RequestMapping(value="/listechamcite")
    public String listechamcite(int idcite,Model model) {
    	model.addAttribute("indique", "listechacite");
		return "categorie";
	}
    
    @RequestMapping(value="/notifications")
    public String notification(@RequestParam int idpro,Model model){
    	model.addAttribute("indique", "noti");
    	Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
    	List<Chambre> chs=metier.notifications(p);
    	model.addAttribute("chambres", chs);
		model.addAttribute("notification", metier.notification(p));
		model.addAttribute("lnotification", chs);
	    model.addAttribute("proprio", model.asMap().get("proprietaires"));
		model.addAttribute("listecite",metier.listeCite(p.getIdProprietaire()));
    	return "categorie";
    }
    
    @RequestMapping(value="/ajoutercite")
    public String savecite(Model model){
    	Proprietaire p=(Proprietaire) model.asMap().get("proprietaires");
    	model.addAttribute("possition", metier.listPoss());
		model.addAttribute("cite", new Cite());
		model.addAttribute("proprietaires", p);
		model.addAttribute("notification", metier.notification(p));
		model.addAttribute("proprio", model.asMap().get("proprietaires"));
		return "accueil";
    }
}

package org.fs.sled;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.fs.sled.entity.Chambre;
import org.fs.sled.metier.IMetier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private IMetier metier;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		model.addAttribute("indix", "listecite");
		model.addAttribute("listecite",metier.listeCite());
		return "clientLo";
	}
	
	@RequestMapping(value="/client/visitechambre")
	public String visiteclient(int idcite, Model model){
		List<Chambre> chs=metier.listchambre(idcite);
		List<Chambre> chams=new ArrayList<Chambre>();
		for (Chambre cha : chs) {
			if (cha.getLocataire()==null) {
				if (cha.getCategorie()!=null) {
					chams.add(cha);
				}
			}
		}
		model.addAttribute("indix", "listechambre");
		model.addAttribute("cite", metier.getCite(idcite));
		model.addAttribute("listechambre", chams);
		return "clientLo";
	}
	@RequestMapping(value="/services/cite")
	public String servicecite(Model model) {
		model.addAttribute("indix", "listecite");
		model.addAttribute("listecite",metier.listeCite());
		return "clietLo";
	}
	
	@RequestMapping(value="/client/reservechambre")
	public String reservechambre(@RequestParam(value="idchambre") int idchambre, Model model) {
		model.addAttribute("chambre", idchambre);
		model.addAttribute("indix", "creercompte");
		return "clientLo";
	}
	
}

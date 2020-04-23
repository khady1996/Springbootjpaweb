package eu.ensup.springbootjpaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import eu.ensup.springbootjpaweb.dao.FormationRepository;
import eu.ensup.springbootjpaweb.domaine.Formation;
import eu.ensup.springbootjpaweb.service.FormationService;
import eu.ensup.springbootjpaweb.service.IFormationService;

@Controller
public class FormationController {
	@Autowired
	private IFormationService service;

	@Bean
	public FormationService service() {
		return new FormationService();
	}
	public FormationController() {
		super();
	}
	
	//Pour accéder à la méthode ci-dessous => exple : http://localhost/formationList/Bilan
	@RequestMapping(value = "/{theme}", method = RequestMethod.GET)
	public String listerLesFormations(@PathVariable("theme") String theme, Model model) {
		System.out.println("Le controleur est dans la méthode listerLesFormations");
		List<Formation> listeFormation = service.listeFormationParTheme(theme);
		if (listeFormation != null) {
		
			model.addAttribute("listeFormation", listeFormation);
		}
		System.out.println(listeFormation);
		return "listeFormationParTheme";
	}

	//Pour accéder à la méthode ci-dessous => exple : http://localhost/formationList/Spring	
	@RequestMapping(value = "/{theme}", method = RequestMethod.POST)
	public String addToFormation(@PathVariable("theme") String theme, Formation formation) {
		System.out.println("Le controleur est dans la méthode addToFormation");
		formation.setTheme(theme);
		service.creerFormation(formation);
		return "redirect:/Formation/{theme}";
	}
	
	@GetMapping("getForm")
	public String getForm() {
		return "listeFormationParTheme";
	}

	@PostMapping("/saveDetails") // it only support port method
	public String saveDetails(@RequestParam("theme") String theme,
			@RequestParam("description") String description, ModelMap modelMap) {

		// write your code to save details
		modelMap.put("theme", theme);
		modelMap.put("description", description);
		return "viewDetails"; // welcome is view name. It will call welcome.jsp
	}

}

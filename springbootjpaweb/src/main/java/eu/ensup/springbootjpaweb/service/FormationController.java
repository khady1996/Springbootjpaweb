package eu.ensup.springbootjpaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import eu.ensup.springbootjpaweb.dao.FormationRepository;
import eu.ensup.springbootjpaweb.domaine.Formation;

@Controller
public class FormationController {

	private FormationRepository formationRepository;

	@Autowired
	public FormationController(FormationRepository formationRepository) {
		this.formationRepository = formationRepository;
	}
	
	//Pour accéder à la méthode ci-dessous => exple : http://localhost/formationList/Bilan
	@RequestMapping(value = "/{theme}", method = RequestMethod.GET)
	public String listerLesFormations(@PathVariable("theme") String theme, Model model) {
		System.out.println("Le controleur est dans la méthode listerLesFormations");
		List<Formation> listeFormation = formationRepository.findByTheme(theme);
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
		formationRepository.save(formation);
		return "redirect:/Formation/{theme}";
	}
}

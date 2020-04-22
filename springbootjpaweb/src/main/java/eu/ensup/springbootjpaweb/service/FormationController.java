package eu.ensup.springbootjpaweb.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import eu.ensup.springbootjpaweb.dao.FormationRepository;
import eu.ensup.springbootjpaweb.domaine.Formation;


@Controller 
@RequestMapping("/formationList") 
public class FormationController {
	
  private FormationRepository FormationRepository;

	@Autowired  
	public FormationController(FormationRepository FormationRepository) {    
		this.FormationRepository = FormationRepository;  
	}

	@RequestMapping(value="/{theme}", method=RequestMethod.GET)  
	public String listerLesFormations(@PathVariable("theme") String theme,  Model model) {
		List<Formation> listeFormation =  FormationRepository.findByTheme(theme);    
		if (listeFormation != null) {      
			model.addAttribute("listeFormation", listeFormation);    
			}    
		return "listeFormationParTheme";  
	}
	
	@RequestMapping(value="/{theme}", method=RequestMethod.POST)  
	public String addToFormation(@PathVariable("theme") String theme, Formation formation) {
		formation.setTheme(theme);    
		FormationRepository.save(formation);    
		return "redirect:/Formation/{theme}";  
	}
}

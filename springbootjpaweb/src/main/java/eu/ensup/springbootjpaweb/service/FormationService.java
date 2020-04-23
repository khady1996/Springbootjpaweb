package eu.ensup.springbootjpaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eu.ensup.springbootjpaweb.dao.FormationRepository;
import eu.ensup.springbootjpaweb.domaine.Formation;

public class FormationService implements IFormationService {
	@Autowired
	private FormationRepository dao;
	
	
	public FormationService(FormationRepository formationRepository) {
		this.dao = formationRepository;
	}
	
	public FormationService() {
		super();
	}

	@Override
	public List<Formation> listeFormationParTheme(String theme) {
		// TODO Auto-generated method stub
		return dao.findByTheme(theme);
	}

	@Override
	public void creerFormation(Formation formation) {
		// TODO Auto-generated method stub
		dao.save(formation);
	}

}

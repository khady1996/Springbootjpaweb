package eu.ensup.springbootjpaweb.service;

import java.util.List;

import eu.ensup.springbootjpaweb.domaine.Formation;

public interface IFormationService {
	public List<Formation> listeFormationParTheme(String theme);
}

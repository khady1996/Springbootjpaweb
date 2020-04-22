package eu.ensup.springbootjpaweb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.ensup.springbootjpaweb.domaine.Formation;

public interface FormationRepository extends JpaRepository<Formation, Long> {
	List<Formation> findByTheme (String theme);
}

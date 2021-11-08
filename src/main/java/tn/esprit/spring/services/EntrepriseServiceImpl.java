package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriserepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	
	@Override
	public List<Entreprise> retrieveAllEntreprise() { 
		List<Entreprise> entreprises = null; 
		try {
	
			l.info("In retrieveAllEntreprises() : ");
			entreprises = (List<Entreprise>) entrepriserepository.findAll();  
			for (Entreprise e : entreprises) {
				l.info("Entreprise +++ : " + e);
			} 
			l.info("Out of retrieveAllEntreprise() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAlldepartment() : " + e);
		}

		return entreprises;
	}


	@Override
	public Entreprise addEntreprise(Entreprise e) {
		return entrepriserepository.save(e); 
	}

	@Override 
	public Entreprise updateEntreprise(Entreprise e) { 
		return entrepriserepository.save(e);
	}

	@Override
	public void deleteEntreprise(String id) {
		entrepriserepository.deleteById(Integer.parseInt(id));
	}

	@Override
	public Entreprise retreieveEntreprise(String id) {
		l.info("in  retrieveEntreprise id = " + id);

		Entreprise d =  entrepriserepository.findById(Integer.parseInt(id)).orElse(null); 

		l.info("Entreprise returned : " + d);
		return d; 
	}


	

}

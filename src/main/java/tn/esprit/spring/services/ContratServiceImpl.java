package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

public class ContratServiceImpl implements IContratService{
	
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	EmployeRepository employeRepository;

	@Override
	public int ajouterContrat(Contrat contrat) {
		contratRepository.save(contrat);
		return contrat.getReference();
	}
	public int getNombreContratJPQL() {
		return contratRepository.countcontrat();
	}

	public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat contratManagedEntity = contratRepository.findById(contratId).get();
		Employe employeManagedEntity = employeRepository.findById(employeId).get();

		contratManagedEntity.setEmploye(employeManagedEntity);
		contratRepository.save(contratManagedEntity);
		
	}

	@Override
	public void deleteContratById(int contratId) {
		Contrat contratManagedEntity = contratRepository.findById(contratId).get();
		contratRepository.delete(contratManagedEntity);

	}


	@Override
	public void deleteAllContratJPQL() {
		// TODO Auto-generated method stub
		
	}

}

package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
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


	@Override
	public void deleteContratById(int contratId) {
		Contrat contratManagedEntity = contratRepository.findById(contratId).orElse(null);
		contratRepository.delete(contratManagedEntity);

	}


	@Override
	public Contrat getContratById(int contratId) {
		return contratRepository.findById((int) contratId).orElse(null);
	}


	@Override
	public List<Contrat> getAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}

}

package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Contrat;
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

	/*public void affecterContratAEmploye(int contratId, int employeId) {
		Contrat contratManagedEntity = contratRepository.findById(contratId).orElse(null);
		Employe employeManagedEntity = employeRepository.findById(employeId).orElse(null);

		if(employeManagedEntity.getContrat() == null){

			List<Contrat> contrats = new ArrayList<>();
			contrats.add(contratManagedEntity);
			employeManagedEntity.setContrats(contrats);
		}else{

			employeManagedEntity.getContrats().add(contratManagedEntity);

		}*/

	@Override
	public void deleteContratById(int contratId) {
		Contrat contratManagedEntity = contratRepository.findById(contratId).orElse(null);
		contratRepository.delete(contratManagedEntity);

	}

}

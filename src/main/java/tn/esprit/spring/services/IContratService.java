package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {

	public int ajouterContrat(Contrat contrat);
	public void deleteContratById(int contratId);
	public Contrat getContratById(int contratId);
	public List<Contrat> getAllContrats();
}

package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RestController
public class RestControlContrat {
	@Autowired
	IContratService contratService;

	@PostMapping("/ajouterContrat")
	@ResponseBody
	public Contrat ajouterContrat(@RequestBody Contrat contrat) {
		contratService.ajouterContrat(contrat);
		return contrat;
	}
	@DeleteMapping("/deleteContratById/{idcontrat}") 
	@ResponseBody
	public void deleteContratById(@PathVariable("idcontrat")int contratId) {
		contratService.deleteContratById(contratId);
	}

}

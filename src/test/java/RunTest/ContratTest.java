package RunTest;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IContratService;

@ContextConfiguration(classes = TimesheetDevOpsApplication.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContratServiceImpl.class)
public class ContratTest {
	//private static final long DEFAULT_TIMEOUT = 10000;
	static final Logger l = LogManager.getLogger(ContratTest.class);
	
	@Autowired
	IContratService contratService;
	@Autowired
	public EmployeServiceImpl employeService;
	
	
	
	/*@Test(timeout = DEFAULT_TIMEOUT)
	public void deleteContratById() {
		Contrat contrat = new Contrat();
		assertNotNull(contrat);
		int id = 4 ;
		contratService.deleteContratById(id);
		
		}*/
	
	@After("execution(* tn.esprit.spring.services.*.*(..))")
	@Test
	public void testAjouterContrat(){
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateDebut = dateFormat.parse("2021-04-30");
			Contrat c1 = new Contrat (dateDebut, "Contrat de travail temporaire", 500);
			l.debug("Contract is being added!");
			employeService.ajouterContrat(c1);
			employeService.deleteContratById(c1.getReference());
			String successMsg = "Contract added successfully!";
			l.info(successMsg);
			l.info("\n");
			l.info(c1);
		} catch (Exception e) {
			l.error(e);
		}
	}
	
	@Test
	public void testAffecterContratAEmploye() {
		try {
			l.debug("Affecting contract to employe");
			employeService.affecterContratAEmploye(1, 1);
			l.info("Contract affected to employe");
		} catch (Exception e) {
			l.error(e);
		}
	}
	
	@Test
	public void testDeleteAllContracts() {
		try {
			l.debug("Deleting all contracts");
			employeService.deleteAllContratJPQL();
			l.info("All contracts are deleted");
		} catch (Exception e) {
			l.error("Error deleting all contracts");
		}
	}
}
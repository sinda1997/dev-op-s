package RunTest;

import static org.junit.Assert.*;

import java.util.logging.LogManager;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.classic.Logger;
import tn.esprit.spring.controller.RestControlEmploye;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
	
	@Autowired
	EmployeServiceImpl employeservice;
	@Autowired
	IEmployeService iemplser;
	@Autowired
	Employe employe;
	@Autowired
	RestControlEmploye employeController;
	
	
	 @Test
	    public void ajouterEmployeTest() throws Exception {

		 employeservice.ajouterEmploye(employe);
		 assertNotNull("L'instance n'est pas créée", employe);
	    }
	 @Test
	 public void testGetNom() {
		    assertEquals("Le nom est incorrect", "nom1", employe.getNom());
		  }
	 @Test
		  public void testSetNom() {
		 employe.setNom("nom2");
		    assertEquals("Le nom est incorrect", "nom2", employe.getNom());
		  }
	 @Test
		  public void testGetPrenom() {
		    assertEquals("Le prenom est incorrect", "prenom1", employe.getPrenom());
		  }
	 @Test
		  public void testSetPrenom() {
		 employe.setPrenom("prenom2");
		    assertEquals("Le prenom est incorrect", "prenom2", employe.getPrenom());
		  }
	 @Test
	  public void testGetEmail() {
	    assertEquals("L'email est incorrect", "email1", employe.getEmail());
	  }
@Test
	  public void testSetEmail() {
	 employe.setPrenom("email2");
	    assertEquals("L'email est incorrect", "email2", employe.getEmail());
	  }
	 @Test 
	 public void getEmployePrenomByIdTest()
	 {
		 String prenom = employeservice.getEmployePrenomById(12350244);
		 assertEquals("meryemgomri", prenom);
	 }
	 @Test
	    public void deleteEmployeTest() throws Exception {
	        // prepare ID to delete
	        Employe meryem =new Employe();
	        employeservice.ajouterEmploye(meryem);
	         int id = meryem.getId();

	         employeController.deleteEmployeById(id);
	        assertEquals("redirect:/deleteEmployeById/{idemp}", meryem);
	        assertNull(employeservice.getAllEmployes());
	    }
}
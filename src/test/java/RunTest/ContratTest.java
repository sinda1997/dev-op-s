package RunTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratTest {
	
	@Autowired
	private IContratService contratService;
	
    private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

   // @Test
   /* public void ajouterContrat() {
        l.info("debut ajouterEntrepriseTest");
        int nbEmps = employeService.getNombreEmployeJPQL();
        l.info("Nombre employes: "+nbEmps);
        int idEmp = employeService.ajouterEmploye(new Employe("Majoul", "Khalil", "mohamedkhalil.majoul@esprit.tn", true, Role.INGENIEUR));
        l.info("id employe: "+idEmp);
        int newNbEmps = employeService.getNombreEmployeJPQL();
        l.info("Nouveau nombre employes: "+newNbEmps);
        Assert.assertEquals(nbEmps+1, newNbEmps);
        Employe e = employeService.getAllEmployes().stream().filter(emp -> emp.getId() == idEmp).findFirst().orElse(null);
        l.info("employe: "+e);
        Assert.assertNotNull(e);
        Assert.assertEquals("Majoul", e.getNom());
        Assert.assertEquals("Khalil", e.getPrenom());
        Assert.assertEquals("mohamedkhalil.majoul@esprit.tn", e.getEmail());
        Assert.assertTrue(e.isActif());
        Assert.assertEquals(Role.INGENIEUR, e.getRole());
        employeService.deleteEmployeById(idEmp);
        l.info("fin ajouterEmployeTest");
    }*/

}

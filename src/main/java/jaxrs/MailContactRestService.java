package jaxrs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jpa.MailContact;
import jpa.Person;

/**
 * Classe rest service pour enregistrer et afficher les mails de contact
 * dans la bd
 * @author Quang LE
 *
 */
@Path("/mail")
public class MailContactRestService {
	
	/**
	 * Méthode ajouter le mail dans la bd depuis un formulaire
	 * @param name le champ nom du formulaire qui sera stocké dans la bd
	 * @param fName le champ prénom du formulaire qui sera stocké dans la bd
	 * @param content le champ content du formulaire qui sera stocké dans la bd
	 * @param mail le champ email du formulaire qui sera stocké dans la bd
	 */
	@POST
	@Path("/add")
	public void addMail(@FormParam("name") String name, @FormParam("fName") String fName, @FormParam("content") String content, @FormParam("mail") String mail) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tp7.sir");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Person p = new Person(name, fName, mail);
			MailContact m = new MailContact(p, content);
			p.getLsMails().add(m);
			manager.persist(p);
			manager.persist(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		factory.close();
		System.out.println("..addMail()..done..");
	}
	
	/**
	 * Méthode GET pour obtenir le json dans une uri
	 * @return json qui contient les mails stockés dans la bd
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MailContact> getMails() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tp7.sir");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		List<MailContact> resultList = manager.createQuery("SELECT aa FROM MailContact aa", MailContact.class).getResultList();
		for (MailContact next : resultList) {
			// boucle infinie pour l'affichage en json donc pour l'object person : on afficheera juste nom et prénom
			next.getPerson().setLsMails(null);
		}
		manager.close();
		factory.close();
		System.out.println("..getMails()..done..");
		return resultList;
	}
}


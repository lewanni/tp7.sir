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

import jpa.Message;

/**
 * Classe ressource pour enregistrer et afficher les messages présents
 * dans la bd
 * @author Quang LE
 *
 */
@Path("/msg")
public class MessageRessource {
	
	/**
	 * Méthode ajouter le message dans la bd depuis un formulaire
	 * @param name le champ nom du formulaire qui sera stocké dans la bd
	 * @param content le champ content du formulaire qui sera stocké dans la bd
	 */
	@POST
	@Path("/add")
	public void addMessage(@FormParam("name") String name, @FormParam("content") String content) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tp7.sir");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			Message m = new Message(name, content);
			manager.persist(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		manager.close();
		factory.close();
		System.out.println("..addMessage()..done..");
	}
	
	/**
	 * Méthode GET pour obtenir le json dans une uri
	 * @return json qui contient les messages stockés dans la bd
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tp7.sir");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		List<Message> resultList = manager.createQuery("SELECT aa FROM Message aa", Message.class).getResultList();
		manager.close();
		factory.close();
		System.out.println("..getMessage()..done..");
		return resultList;
	}
}

package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Classe de test pour ajouter des entités messages
 * et tester les requêtes JPA 
 * @author Quang LE
 *
 */
public class JpaTest {
	/**
	 * L'entité manager pour gérer la persistance des entité
	 */
	private EntityManager manager;
	
	/**
	 * Constructeur de la classe de test
	 * @param manager entité manager à déclarer
	 */
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tp7.sir");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			test.createMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listMessages();
		manager.close();
		factory.close();
		System.out.println(".. done");
	}
	
	/**
	 * Fonction qui crée 5 messages si la bd est vide
	 */
	private void createMessage() {
		int numOfMsg = manager.createQuery("SELECT a FROM Message a", Message.class).getResultList().size();
		if (numOfMsg == 0) {
			for (int i = 0; i < 5; i++) {
				Message m = new Message("titi" + i, "coucou" + i);
				manager.persist(m);
			}
		}
	}
	
	/**
	 * Fonction qui affiche la liste des messages présents dans la bd
	 */
	private void listMessages() {
		List<Message> resultList = manager.createQuery("SELECT a FROM Message a", Message.class).getResultList();
		System.out.println("number of messages : " + resultList.size());
		System.out.println("Messages :");
		for (Message next : resultList) {
			System.out.println(next.getName() + " a écrit: " + next.getContent());
		}
	}
}

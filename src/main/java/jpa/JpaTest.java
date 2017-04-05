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
			test.createMail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listMessages();
		test.listMails();
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
	 * Fonction qui crée 5 mails par une personne si la bd est vide
	 */
	private void createMail() {
		int numOfMail = manager.createQuery("SELECT a FROM MailContact a", MailContact.class).getResultList().size();
		if (numOfMail == 0) {
			Person p = new Person("le", "quang", "quang2017@gmai.com");
			for (int i = 0; i < 5; i++) {
				MailContact mail = new MailContact(p, "ke" + i);
				p.getLsMails().add(mail);
				manager.persist(p);
				manager.persist(mail);
			}
			Person p1 = new Person("le", "quang", "quang2017@gmai.com");
			MailContact mail1 = new MailContact(p1, "ke1");
			p1.getLsMails().add(mail1);
			manager.persist(p1);
			manager.persist(mail1);
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
	
	/**
	 * Fonction qui affiche la liste des mails
	 */
	private void listMails() {
		List<MailContact> resultList = manager.createQuery("SELECT a FROM MailContact a", MailContact.class).getResultList();
		System.out.println("number of mails : " + resultList.size());
		System.out.println("Mails :");
		for (MailContact next : resultList) {
			System.out.println(next.getPerson().getName() + " a écrit: " + next.getContent() + " à " + next.getDate());
		}
	}
}

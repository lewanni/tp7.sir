package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
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
	
	private void createMessage() {
		int numOfMsg = manager.createQuery("SELECT a FROM Message a", Message.class).getResultList().size();
		if (numOfMsg == 0) {
			for (int i = 0; i < 5; i++) {
				Message m = new Message("titi" + i, "coucou" + i);
				manager.persist(m);
			}
		}
	}

	private void listMessages() {
		List<Message> resultList = manager.createQuery("SELECT a FROM Message a", Message.class).getResultList();
		System.out.println("number of messages : " + resultList.size());
		System.out.println("Messages :");
		for (Message next : resultList) {
			System.out.println(next.getContent());
		}
	}
}

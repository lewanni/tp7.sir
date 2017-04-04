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

@Path("/msg")
public class MessageRessource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Coucou ptit test";
	}
	
	@POST
	@Path("/add")
	public String addMessage(@FormParam("name") String name, @FormParam("content") String content) {
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
		System.out.println(".. done.. Message envoyé et registré dans la bd");
		String response = "Dernier message envoyé par " + name + " : " + content + "\n"
				+ "<h1>aaaa</h1>";
		return response;
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tp7.sir");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		
		List<Message> resultList = manager.createQuery("SELECT aa FROM Message aa", Message.class).getResultList();
		System.out.println("number of messages : " + resultList.size());
		System.out.println(resultList);
		System.out.println("Messages :");
		for (Message next : resultList) {
			System.out.println(next.getName() + " a écrit : " + next.getContent());
		}
		manager.close();
		factory.close();
		System.out.println(".. done.. Message envoyé et registré dans la bd");
		return resultList;
	}
}

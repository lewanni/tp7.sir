package jpa;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entité JPA  et instance Message
 * @author Quang LE
 *
 */
@Entity
@Table(name = "Message")
public class Message {
	
	/**
	 * id unique pour chaque instance/entité Message
	 */
	private long id;
	
	/**
	 * Nom de la personne qui a envoyé le message
	 */
	@Column(name = "Name")
	private String name;
	
	/**
	 * Le contenu du message
	 */
	@Column(name = "Content")
	private String content;
	
	/**
	 * La date de l'envoi du message 
	 */
	@Column(name = "Date")
	private String date;
	
	/**
	 * Constructeur de l'instance Message
	 * @param name Nom de l'émetteur
	 * @param content Contenu du message
	 */
	public Message(String name, String content) {
		this.name = name;
		this.content = content;
		this.date = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
	}
	
	/**
	 * Constructeur de l'instance Message par défaut
	 */
	public Message() {
		
	}
	
	/**
	 * Obtenir le contenu du message
	 * @return Contenu du message
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Remplacer le contenu du message
	 * @param content Contenu du message à remplacer
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Obtenir le nom de l'émetteur du message
	 * @return Nom de l'émetteur du message
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Remplacer le nom de l'émetteur du message
	 * @param user nom de l'émetteur du message à remplacer
	 */
	public void setName(String user) {
		this.name = user;
	}
	
	/**
	 * Obtenir Id de l'instance Message
	 * @return Id de l'instance Message
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	/**
	 * Remplacer l'id du message
	 * @param id Id à remplacer pour l'objet Message
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Obtenir la date du message envoyé 
	 * @return Date du message envoyé 
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Remplacer la date du message
	 * @param date Date du message à remplacer
	 */
	public void setDate(String date) {
		this.date = date;
	}
}

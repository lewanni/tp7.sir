package jpa;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entité JPA  et instance Mail de contact
 * @author Quang LE
 *
 */
@Entity
@Table(name = "MailContact")
public class MailContact {
	
	/**
	 * id unique pour chaque instance/entité Mail
	 */
	private long id;
	
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
	 * La personne qui a envoyé le mail 
	 */
	@Column(name = "Person")
	private Person person;
	/**
	 * Constructeur de l'instance Message
	 * @param name Nom de l'émetteur
	 * @param content Contenu du message
	 */
	public MailContact(Person p, String content) {
		this.person = p;
		this.content = content;
		this.date = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(new Date());
	}
	
	/**
	 * Constructeur de l'instance Message par défaut
	 */
	public MailContact() {
		
	}
	
	/**
	 * Obtenir le contenu du mail
	 * @return Contenu du mail
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Remplacer le contenu du mail
	 * @param content Contenu du mail à remplacer
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Obtenir l'émetteur du mail
	 * Plusieurs mails peuvent venir d'une seule personne
	 * Jointure entre 2 entités Person et mailContact
	 * @return L'émetteur du mail
	 */
	@ManyToOne
	public Person getPerson() {
		return person;
	}
	
	/**
	 * Remplacer l'émetteur du mail par un autre
	 * @param person émetteur du mail à remplacer
	 */
	public void setPerson(Person person) {
		this.person = person;
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

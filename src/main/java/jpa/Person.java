package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entité persitante/instance Person qui envoie un mail de contact
 * @author Quang LE
 *
 */
@Entity
@Table(name = "PERSONNE")
public class Person {
	
	/**
	 * Id d'une personne
	 */
	private long id;
	
	/**
	 * Nom de la personne
	 */
	@Column(name = "Nom")
	private String name;
	
	/**
	 * Prénom d'une personne
	 */
	@Column(name = "Prénom")
	private String firstName;
	
	/**
	 * email d'une personne
	 */
	@Column(name = "E-mail")
	private String mail;
	
	/**
	 * Liste des messages que la personne a envoyé
	 */
	private List<MailContact> lsMails;
	
	/**
	 * Constructeur person
	 * @param nam nom
	 * @param fn prénom
	 * @param mail email
	 */
	public Person(String nam, String fn, String mail) {
		this.name = nam;
		this.firstName = fn;
		this.mail = mail;
		this.lsMails = new ArrayList<MailContact>();
	}
	
	/**
	 * Constructeur par défaut
	 */
	public Person() {

	}
	
	/**
	 * Obtenir nom de la personne
	 * @return nom de la personne
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Remplacer le nom de la personne
	 * @param name  nom de la personne à remplacer
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Obtenir le prénom
	 * @return prénom
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Remplacer prénom
	 * @param firstName prénom à remplacer
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Obtenir email
	 * @return email
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * Remplacer email
	 * @param mail email à remplacer
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * toString de la personne en affichant : nom, prénom, email
	 */
	@Override
	public String toString() {
		return "Person [nom=" + name + ", prenom=" + firstName + ", email=" + mail + "]";
	}

	/**
	 * Obtenir id
	 * @return id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	/**
	 * Remplacer id
	 * @param id id à remplacer
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Obtenir la liste emails que la personne a envoyé 
	 * Jointure entre 2 entités Person et mailContact
	 * @return liste emails que la personne a envoyé 
	 */
	@OneToMany(mappedBy="person", cascade = CascadeType.ALL)
	public List<MailContact> getLsMails() {
		return lsMails;
	}
	
	/**
	 * Remplacer une liste de mails de contact
	 * @param lsMails Liste de mails de contact à remplacer
	 */
	public void setLsMails(List<MailContact> lsMails) {
		this.lsMails = lsMails;
	}
}

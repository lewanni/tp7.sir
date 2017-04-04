package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message {
	
	private long id;
	@Column(name = "Name")
	private String name;
	@Column(name = "Content")
	private String content;

	public Message(String name, String content) {
		this.name = name;
		this.content = content;
	}
	
	public Message() {
		
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String user) {
		this.name = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

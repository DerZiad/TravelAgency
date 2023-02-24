package ma.wiebatouta.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="messages")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255)
	@Length(min=5,max=255,message="Le message doit être entre 5 et 255 caractères")
	private String message;
	@Column(length = 35)
	@Length(min=5,max=35,message="Le sujet doit être entre 5 et 35 caractères")
	private String sujet;
	
	private long startTime = System.currentTimeMillis();
	
	
	/**
	 * Relations
	 * */
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},targetEntity = User.class)
	@JsonIgnore
	private User user;

	public Message(String message, String sujet, User user) {
		super();
		this.message = message;
		this.sujet = sujet;
		this.user = user;
	}
	
	public String getUsername() {
		return user.getUsername();
	}
	
}

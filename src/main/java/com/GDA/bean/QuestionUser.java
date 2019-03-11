package main.java.com.GDA.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_user")
public class QuestionUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSecretQuestion;
	
	@Column(length = 250, nullable = false)
	private String question;
	
	@Column(length = 250, nullable = false)
	private String response;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Integer idUser;
	
	
	
	
	
	public QuestionUser() {
		super();
	}
	
	public QuestionUser(Integer idSecretQuestion, String question, String response, int idUser) {
		super();
		this.idSecretQuestion = idSecretQuestion;
		this.question = question;
		this.response = response;
		this.idUser = idUser;
	}
	public Integer getIdSecretQuestion() {
		return idSecretQuestion;
	}
	public void setIdSecretQuestion(Integer idSecretQuestion) {
		this.idSecretQuestion = idSecretQuestion;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	
}

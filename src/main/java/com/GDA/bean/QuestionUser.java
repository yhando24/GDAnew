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
@Table(name = "question_user")
public class QuestionUser {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSecretQuestion;

	@NotBlank
	@Column(length = 250, nullable = false)
	private String question;

	@NotBlank
	@Column(length = 250, nullable = false)
	private String response;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public QuestionUser() {
		super();
	}

	public QuestionUser(Integer idSecretQuestion, String question, String response, User idUser) {
		super();
		this.idSecretQuestion = idSecretQuestion;
		this.question = question;
		this.response = response;
		this.user = idUser;
	}

	@NotNull
	public Integer getIdSecretQuestion() {
		return idSecretQuestion;
	}

	public void setIdSecretQuestion(Integer idSecretQuestion) {
		this.idSecretQuestion = idSecretQuestion;
	}

	@NotBlank
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@NotBlank
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@NotNull
	public User getUser() {
		return user;
	}

	public void setIdUser(User user) {
		this.user = user;
	}

}

package main.java.com.GDA.bean;

public class QuestionUser {

	private int idSecretQuestion;
	private String question;
	private String response;
	private int idUser;
	
	
	
	
	
	public QuestionUser() {
		super();
	}
	
	public QuestionUser(int idSecretQuestion, String question, String response, int idUser) {
		super();
		this.idSecretQuestion = idSecretQuestion;
		this.question = question;
		this.response = response;
		this.idUser = idUser;
	}
	public int getIdSecretQuestion() {
		return idSecretQuestion;
	}
	public void setIdSecretQuestion(int idSecretQuestion) {
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

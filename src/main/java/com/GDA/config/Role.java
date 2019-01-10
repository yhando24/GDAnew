package main.java.com.GDA.config;

public enum Role {

	ROLE_ADMIN (1),
	ROLE_MANAGER (2),
	ROLE_EMPLOYEE (3);

	private Integer num = null;
	   
	  //Constructeur
	  Role(Integer num){
	    this.setName(num);
	  }

	public Integer getNum() {
		return num;
	}

	public void setName(Integer num) {
		this.num = num;
	}
	   
}

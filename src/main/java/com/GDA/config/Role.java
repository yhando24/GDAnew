package main.java.com.GDA.config;

public enum Role {

	ROLE_ADMIN (1),
	ROLE_MANAGER (2),
	ROLE_EMPLOYEE (3);

	/** L'attribut qui contient la valeur associé à l'enum */
	private final int value;
 
	/** Le constructeur qui associe une valeur à l'enum */
	private Role(int value) {
		this.value = value;
	}
 
	/** La méthode accesseur qui renvoit la valeur de l'enum */
	public int getValue() {
		return this.value;
	}
}



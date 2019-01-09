package main.java.com.GDA.bean;

public class TypeJourFerie {

	private int id;
	private String name;
	
	public TypeJourFerie(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public TypeJourFerie() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AbsenceType [id=" + id + ", name=" + name + "]";
	}
		
}

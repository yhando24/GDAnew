package main.java.com.GDA.bean;

public class Status {

	private int id;
	private String name;
	
	public Status(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Status(int id) {
	
		this.id = id;

	}

	public Status() {
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
		return "Status [id=" + id + ", name=" + name + "]";
	}
	
	
}

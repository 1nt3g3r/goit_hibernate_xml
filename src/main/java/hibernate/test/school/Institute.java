package hibernate.test.school;

public class Institute {
	private int id;
	private String name;
	
	public Institute() {
	}
	
	public Institute(String name) {
		this.name = name;
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
		return "Institute{" +
				"name='" + name + '\'' +
				'}';
	}
}

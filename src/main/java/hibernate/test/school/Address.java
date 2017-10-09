package hibernate.test.school;

public class Address implements Comparable<Address> {
	private int id;
	private String location;

	public Address() {
	}
	
	public Address(String location) {
		this.location = location;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Address address = (Address) o;

		return location != null ? location.equals(address.location) : address.location == null;
	}

	@Override
	public int hashCode() {
		return location != null ? location.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", location='" + location + '\'' +
				'}';
	}

	public int compareTo(Address o) {
		Address another = (Address) o;
		return o.location.compareTo(location);
	}
}

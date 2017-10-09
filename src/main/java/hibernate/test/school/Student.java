package hibernate.test.school;

import java.util.*;

public class Student {
	private int id;
	private String name;
	private String lastname;

	private List<Mark> marks; //<list>, <bag>, <one-to-many>

	private Set<Address> addresses; // <set>, <one-to-many>
	private Set<Address> sortedAddresses; // <set sort=""/>, <one-to-many>

	private Map<String, Pet> pets; // <map>, <one-to-many>
	private Map<String, Pet> sortedPets; //<map sort=""/>, <one-to-many>

	private FullName fullName; // <component>

	private DetailedInfo detailedInfo; // <one-to-one>

	private Set<Article> articles; // <many-to-many>

	private Institute institute; // <many-to-one>

	public Student() {
	}
	
	public Student(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
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
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public List<Mark> getMarks() {
		return marks;
	}
	
	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Address> getSortedAddresses() {
		return sortedAddresses;
	}

	public void setSortedAddresses(Set<Address> sortedAddresses) {
		this.sortedAddresses = sortedAddresses;
	}

	public Map<String, Pet> getPets() {
		return pets;
	}

	public void setPets(Map<String, Pet> pets) {
		this.pets = pets;
	}

	public Map<String, Pet> getSortedPets() {
		return sortedPets;
	}

	public void setSortedPets(Map<String, Pet> sortedPets) {
		this.sortedPets = sortedPets;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public DetailedInfo getDetailedInfo() {
		return detailedInfo;
	}

	public void setDetailedInfo(DetailedInfo detailedInfo) {
		this.detailedInfo = detailedInfo;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", lastname='" + lastname + '\'' +
				", marks=" + marks +
				", addresses=" + addresses +
				", pets=" + pets +
				", sortedPets=" + sortedPets +
				", fullName=" + fullName +
				", detailedInfo=" + detailedInfo +
				", articles=" + articles +
				", institute=" + institute +
				'}';
	}
}

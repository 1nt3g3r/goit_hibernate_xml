package hibernate.test.school;

import java.util.Set;

public class Article {
	private int id;
	private Set<Student> students;
	private String content;
	
	public Article() {
	}

	public Article(String content) {
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public boolean equals(Object obj) {
		Article another = (Article) obj;
		return another.content.equals(content);
	}
	
	@Override
	public int hashCode() {
		return content.hashCode();
	}

	@Override
	public String toString() {
		return "Article{" +
				"content='" + content + '\'' +
				'}';
	}
}

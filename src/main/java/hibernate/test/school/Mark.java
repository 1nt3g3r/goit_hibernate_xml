package hibernate.test.school;

import java.util.Date;

public class Mark {
	private int id;
	private String subject;
	private String teacher;
	private int value;
	
	public Mark() {
	}
	
	public Mark(String teacher, String subject, int value) {
		this.teacher = teacher;
		this.subject = subject;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Mark mark = (Mark) o;

		if (value != mark.value) return false;
		return subject != null ? subject.equals(mark.subject) : mark.subject == null;
	}

	@Override
	public int hashCode() {
		int result = subject != null ? subject.hashCode() : 0;
		result = 31 * result + value;
		return result;
	}

	@Override
	public String toString() {
		return "Mark{" +
				"subject='" + subject + '\'' +
				", teacher='" + teacher + '\'' +
				", value=" + value +
				'}';
	}
}

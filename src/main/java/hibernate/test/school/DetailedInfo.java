package hibernate.test.school;

import java.util.Date;

public class DetailedInfo {
    private int id;
    private String birthday;
    private String phone;
    private Student student;

    public DetailedInfo() {
    }

    public DetailedInfo(String birthday, String phone) {
        this.birthday = birthday;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "DetailedInfo{" +
                "id=" + id +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

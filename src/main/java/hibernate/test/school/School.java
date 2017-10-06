package hibernate.test.school;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class School {
    private SessionFactory sessionFactory;

    public School() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

	public static void main(String[] args) {
        //TODO write code here
	}
}

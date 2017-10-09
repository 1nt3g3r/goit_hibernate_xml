package hibernate.test.school;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class School {
    private SessionFactory sessionFactory;

    public School() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void addStudent(Student student, Set<Article> articles) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
            student.setArticles(articles);
            session.save(student);
        transaction.commit();
        session.close();
    }

    private int addInstitute(Institute institute) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (Integer) session.save(institute);
        transaction.commit();
        session.close();
        return id;
    }

    public void printAllStudents() {
        for(Student student: getAllStudents()) {
            System.out.println(student);
            System.out.println();
        }
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student").list();
        session.close();
        return students;
    }

    /**
     * Запускайте по одному, коментуючи інші
     */
	public static void main(String[] args) {
        //Перші п'ять прикладів - це одночасно зв'язок один-до-багатьох

        listAndBagExample();
        //unsortedSetExample();
        //sortedSetExample();
        //unsortedMapExample();
	    //sortedMapExample();

        oneToOneExample();
        manyToManyExample();
        manyToOneExample();
    }

    /**
     * У студента є список оцінок. Зв'язок типу один-до-багатьох, оцінки впорядковані, зберігаються у списку.
     *
     * У Student.xml це виглядає так:
     *
     * <list name="marks" cascade="all" lazy="false">
     * <key column="student_id"></key>
     * <list-index column="idx"/>
     * <one-to-many class="hibernate.test.school.Mark"/>
     * </list>
     *
     * Якщо порядок неважливий - можна використати <bag>. Оскільки нам не потрібно сортувати результати,
     * <list-index> вже непотрібний, і маппінг буде без нього:
     *
     * <bag name="marks" cascade="all" lazy="false">
     * <key column="student_id"></key>
     * <one-to-many class="hibernate.test.school.Mark"/>
     * </bag>
     *
     *
     */
	private static void listAndBagExample() {
        School school = new School();

        Student student = new Student("Даша", "Іванова");

        List<Mark> marks = new ArrayList<Mark>();
        marks.add(new Mark("Максимов", "Фізика", 5));
        marks.add(new Mark("Ківащенко", "Математика", 4));
        student.setMarks(marks);

        school.addStudent(student);

        school.printAllStudents();
    }

    /**
     * Є множина адрес, за якими студент може проживати (місце прописки, фактичне місце проживанння і т.д.).
     * Ці дані ми зберігаємо у вигляді несортованої множини - <set></set>
     *
     * <set name="addresses" cascade="all" lazy="false">
     * <key column="student_id"></key>
     * <one-to-many class="hibernate.test.school.Address"/>
     * </set>
     */
    private static void unsortedSetExample() {
        School school = new School();

        Student student = new Student("Даша", "Іванова");

        Set<Address> addresses = new HashSet<Address>();
        addresses.add(new Address("Київ, вул. Печерська, 45, кв. 6"));
        addresses.add(new Address("Харків, вул. Космонавтів, 19, кв. 18"));
        student.setAddresses(addresses);

        school.addStudent(student);

        school.printAllStudents();
    }

    /**
     * Є множина адрес, за якими студент може проживати (місце прописки, фактичне місце проживанння і т.д.).
     * Ці дані ми зберігаємо у вигляді СОРТОВАНОЇ множини - <set></set>. Зверніть увагу, що ми додаємо елементи в одному порядку,
     * але виводяться вони в іншому - це тому, що ми сортуємо їх перед виводом
     *
     * Для сортування ми використовуємо написаний нами компаратор - sort="hibernate.test.school.CustomAddressComparator"
     *
     * Також можна сортувати методом compareTo об'єктів, що сортуються. Тоді потрібно написати sort="natural".
     *
     * Ну і клас об'єктів, що ми сортуємо, повинний реалізувати інтерфейс Comparable (в нашому випадку Address реалізує цей інтерфейс)
     *
     * <set name="addresses" cascade="all" lazy="false" sort="hibernate.test.school.CustomAddressComparator">
     * <key column="student_id"></key>
     * <one-to-many class="hibernate.test.school.Address"/>
     * </set>
     */
    private static void sortedSetExample() {
        School school = new School();

        Student student = new Student("Даша", "Іванова");

        Set<Address> addresses = new TreeSet<Address>();
        addresses.add(new Address("Харків, вул. Космонавтів, 19, кв. 18"));
        addresses.add(new Address("Київ, вул. Печерська, 45, кв. 6"));
        student.setAddresses(addresses);

        school.addStudent(student);

        school.printAllStudents();
    }

    /**
     * У студентів є домашні тварини. У кожної тварини є кличка, опис, і додаткові характеристики - наприклад, вага.
     *
     * Ми зберігаємо дані про тварин у вигляді пар "ключ-значення", де ключом виступає кличка тварини. Ми НЕ СОРТУЄМО дані у цьому прикладі
     *
     * <map name="pets" cascade="all" lazy="false">
     * <key column="student_id"></key>
     * <map-key column="name" type="string"/>
     * <one-to-many class="hibernate.test.school.Pet"/>
     * </map>
     */
    private static void unsortedMapExample() {
        School school = new School();

        Student student = new Student("Даша", "Іванова");

        Map<String, Pet> pets = new HashMap<String, Pet>();
        pets.put("Мурчик", new Pet("Простий кіт", 5));
        pets.put("Шарик", new Pet("Німецька вівчарка", 25));
        student.setPets(pets);

        school.addStudent(student);

        school.printAllStudents();
    }

    /**
     * У такому варіанті тварини будуть відсортовані згідно їх імені.
     *
     * <map name="pets" cascade="all" lazy="false">
     * <key column="student_id"></key>
     * <map-key column="name" type="string"/>
     * <one-to-many class="hibernate.test.school.Pet"/>
     * </map>
     */
    private static void sortedMapExample() {
        School school = new School();

        Student student = new Student("Даша", "Іванова");

        Map<String, Pet> sortedPets = new TreeMap<String, Pet>();
        sortedPets.put("Мурчик", new Pet("Простий кіт", 5));
        sortedPets.put("Шарик", new Pet("Німецька вівчарка", 25));
        student.setSortedPets(sortedPets);

        school.addStudent(student);

        school.printAllStudents();
    }

    /**
     * Зв'язок один до одного - студент і детальна інформація про нього
     *
     * <one-to-one name="detailedInfo" class="hibernate.test.school.DetailedInfo" cascade="save-update" lazy="false"></one-to-one>
     */
    private static void oneToOneExample() {
        School school = new School();

        Student student = new Student("Даша", "Іванова");

        DetailedInfo info = new DetailedInfo("23.09.1987", "0939985349");
        student.setDetailedInfo(info);
        info.setStudent(student);

        school.addStudent(student);

        school.printAllStudents();
    }

    /**
     * Зв'язок багато-до-багатьох - студенти і статті, які вони писали.
     *
     * Один студент може бути співавтором декількох статей, і у одної статті може бути декілька співаторів
     *
     * <set name="articles" table="ARTICLE_STUDENT" lazy="false" cascade="all" inverse="false">
     * <key>
     * <column name="student_id"/>
     * </key>
     * <many-to-many entity-name="hibernate.test.school.Article">
     * <column name="article_id"/>
     * </many-to-many>
     * </set>
     */
    private static void manyToManyExample() {
        School school = new School();

        // Формуємо статті
        Article articleA = new Article("Про слонів");
        Article articleB = new Article("Про електрику");

        Set<Article> articles = new HashSet<Article>();
        articles.add(articleA);
        articles.add(articleB);

        // І Даша і Саша приймали участь в написанні статей
        Student studentDasha = new Student("Даша", "Іванова");
        Student studentSasha = new Student("Саша", "Козаченко");

        school.addStudent(studentDasha, articles);
        school.addStudent(studentSasha, articles);

        school.printAllStudents();
    }

    /**
     * Один студент може навчатись очно лише в одному інституті.
     *
     * В той же час в одному інституті на очному навчається багато студентів.
     *
     <many-to-one name = "institute" column = "INSTITUTE" class="hibernate.test.school.Institute" lazy="false"/>
     */
    private static void manyToOneExample() {
        School school = new School();

        Institute institute = new Institute("КПІ");
        school.addInstitute(institute);

        Student studentKolia = new Student("Маша", "Демченко");
        studentKolia.setInstitute(institute);
        school.addStudent(studentKolia);

        Student studentBill = new Student("Білл", "Британець");
        studentBill.setInstitute(institute);
        school.addStudent(studentBill);

        school.printAllStudents();
    }

}

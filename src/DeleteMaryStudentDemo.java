import Entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMaryStudentDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

                try{
                    //start a transaction
                    session.beginTransaction();

                    //get the student mary from database
                    int studentId = 2;
                    Student student = session.get(Student.class, studentId);

                    System.out.println("\nLoad student: " + student);
                    System.out.println("Courses: " + student.getCourses());

                    //deleting mary
                    System.out.println("\nDeleting student: " + student);
                    session.delete(student);

                    //commit transaction
                    session.getTransaction().commit();
                    System.out.println("Done!");
                }
                finally {
                    session.close();
                    factory.close();
                }
    }


}

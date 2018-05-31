import Entity.Course;
import Entity.Instructor;
import Entity.InstructorDetail;
import Entity.Review;
import Entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {
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

                    //create a course
                    Course course = new Course("Pacman - How To Score One Million Points2");
                   
                    //save the course
                    System.out.println("\n Svaing the course...");

                    System.out.println(course);

                    System.out.println("Saved the course: " + course);
                    
                    //create the students
                    Student theStudent1 = new Student("John", "Doe", "john@luv2code.com");
                    Student theStudent2 = new Student("Mary", "Public", "mary@luv2code.com");

                    //add students to the course
                    course.addStudent(theStudent1);
                    course.addStudent(theStudent2);
                    //save the students
                    System.out.println("\nSaving students");
                    session.save(theStudent1);
                    session.save(theStudent2);
                    System.out.println("\nSaved students: " + course.getStudents());

                    
                    session.save(course);

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

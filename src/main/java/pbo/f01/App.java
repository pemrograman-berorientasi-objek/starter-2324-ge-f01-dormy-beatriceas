package pbo.f01;

import java.util.List;
import javax.persistence.*;

import pbo.f01.model.Dorm;
import pbo.f01.model.Student;

/**
 * 12S22020 - Beatrice Siahaan
 * 12S22040 - Gracia Purba
 */
public class App {
    
    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    public static void main(String[] args) {
        try {
            factory = Persistence.createEntityManagerFactory("dormy_pu");
            entityManager = factory.createEntityManager();

            // display
            displayAllDorms();
            displayAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
            if (factory != null && factory.isOpen()) {
                factory.close();
            }
        }
        System.out.println("Hello");
    }

    private static void displayAllDorms() {
        String jpql = "SELECT c FROM Dorm c ORDER BY c.name";
        List<Dorm> dorms = entityManager.createQuery(jpql, Dorm.class)
                .getResultList();

        System.out.println("displayAllDorms--");
        for (Dorm c : dorms) {
            System.out.println(c);
        }
    }

    private static void displayAllStudents() {
        String jpql = "SELECT g FROM Student g ORDER BY g.id";
        List<Student> students = entityManager.createQuery(jpql, Student.class)
                .getResultList();

        System.out.println("displayAllStudents--");
        for (Student g : students) {
            System.out.println(g);

            String Students = g.getStudentId();
            for (Student c : students) {
                System.out.println(c);
            }
        }
    }
}

package app.repositoryTest;

import org.centaurus.app.config.HibernateConfig;
import org.centaurus.app.models.Student;
import org.centaurus.app.repository.modelRepository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class RepositoryStudentTest {
    private Logger logger = LoggerFactory.getLogger(RepositoryStudentTest.class);
    HibernateConfig hibernateConfig = new HibernateConfig();
    StudentRepository studentRepository = new StudentRepository();
    Set<Student> students = new HashSet<>();
    Student studentEX = new Student();
    Student studentAC = new Student();

    @BeforeEach
    public void setUp() {
        studentRepository.setSessionFactory(hibernateConfig.getSessionFactory());
    }

    @Test
    public void save() {
        studentEX.setMatricul("15J2740");
        studentEX.setName("TOMFEU");
        studentEX.setSurname("Boris");

        studentRepository.save(studentEX);
        Assertions.assertEquals(studentAC, studentAC, "show difference");
    }

    @Test
    public void getAll() {
        students.addAll(studentRepository.findAll());
        for (Student student : students) {
            logger.info(student.toString());
        }
        Assertions.assertArrayEquals(new Set[]{students}, new Set[]{students}, "error");
    }

    @Test
    public void delete() {
        studentAC.setMatricul("15T2498");
        Assertions.assertTrue(studentRepository.delete(studentAC));
    }

    @Test
    public void findById() {
        studentAC = studentRepository.findById("15T2498");
        logger.info("student info " + studentAC.toString());
        Assertions.assertEquals(studentAC, studentAC, "error");
    }

    @Test
    public void update() {
        studentAC.setMatricul("15T2498");
        studentAC.setName("TEMEGNI");
        studentAC.setSurname("Anderson");
        studentRepository.update(studentAC);
        logger.info("up-to-date " + studentAC.toString());
    }

    @Test
    public void updateId() {
        studentRepository.updateMatricul("15J2740","15T2498");
    }
}

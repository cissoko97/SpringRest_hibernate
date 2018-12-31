package app.repositoryTest;

import org.centaurus.app.config.HibernateConfig;
import org.centaurus.app.models.Person;
import org.centaurus.app.repository.modelRepository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RepositoryPersonTest {
    private Logger logger = LoggerFactory.getLogger(RepositoryPersonTest.class);
    private PersonRepository personRepository = new PersonRepository();
    private Person person = new Person();
    private HibernateConfig hibernateConfig = new HibernateConfig();

    @BeforeEach
    public void setUp() {
        personRepository.setSessionFactory(hibernateConfig.getSessionFactory());
    }

    @Test
    public void save() {
        person.setName("Tomfeu");
        person.setSurname("Cissoko");
        person.setBornOf(new Date());
        person.setEmail("btomfeu@yahoo.com");
        person.setPassword("boris@ck0397");
        person.setSexe(Boolean.TRUE);
        personRepository.save(person);
        logger.info("new person id: " + person.toString());
        Assertions.assertEquals(person.getId(), person.getId());
    }

    @Test
    public void findById() {
        person = personRepository.findById(1);
        logger.info("person found id: " + person.toString());
        Assertions.assertEquals(person, person, "failed");
    }

    @Test
    public void getAll() {
        Set<Person> persons = personRepository.findAll();
        person.setId(1);
        Set<Person> exp = new HashSet<>();
        exp.add(person);
        for (Person p : persons) {
            logger.info("this index :" + p.toString());
        }
        Assertions.assertArrayEquals(new Set[]{exp}, new Set[]{persons}, "failed");
    }

    @Test
    public void findByEmailAndPassword() {
        String email = "btomfeu@yahoo.com";
        String password = "boris@ck0397";
        person.setSurname("Cissoko");
        person = personRepository.findByEmailAndPassword(email, password);
        logger.info("Person found by email and password" + person.toString());
        Person p = new Person();
        p.setId(1);
        Assertions.assertEquals(p,person,"failed");
    }

    @Test
    public void DeleteByEmailAndPassword() {
        String email = "btomfeu@yahoo.com";
        String password = "boris@ck0397";
        person.setSurname("Cissoko");
        personRepository.deleteByEmailAndPassword(email, password);
    }
}

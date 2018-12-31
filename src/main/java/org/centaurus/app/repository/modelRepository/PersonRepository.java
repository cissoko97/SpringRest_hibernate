package org.centaurus.app.repository.modelRepository;

import org.centaurus.app.models.Person;
import org.centaurus.app.repository.Repository;
import org.centaurus.app.repository.modelRepository.IRepositoy.IPersonRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository extends Repository<Person, Integer> implements IPersonRepository {

    @Override
    public Person findByEmailAndPassword(String email, String password) {
        //getInstance();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("FROM Person p WHERE p.email =:email AND p.password =:password");
        query.setString("email", email);
        query.setString("password", password);

        return (Person) query.uniqueResult();
    }

    @Override
    public void deleteByEmailAndPassword(String email, String password) {
        //getInstance();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("DELETE FROM Person p WHERE p.email =:email AND p.password =:password");
        query.setString("email", email);
        query.setString("password", password);

        query.executeUpdate();
    }

    @Override
    public Boolean ifExist(String email, String password) {
        if (findByEmailAndPassword(email , password) != null)
        {
            return Boolean.TRUE;
        }else {
            return Boolean.FALSE;
        }
    }
}

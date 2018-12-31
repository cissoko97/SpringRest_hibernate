package org.centaurus.app.repository.modelRepository;

import org.centaurus.app.models.Student;
import org.centaurus.app.repository.Repository;
import org.centaurus.app.repository.modelRepository.IRepositoy.IStudentRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository extends Repository<Student, String> implements IStudentRepository {

    @Override
    public int updateMatricul(String before, String after) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("UPDATE Student s SET s.id =:after where s.id=:before");
        query.setParameter("after", after);
        query.setParameter("before", before);
        int i = query.executeUpdate();
        session.getTransaction().commit();
        return i;
    }
}

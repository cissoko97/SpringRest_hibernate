package org.centaurus.app.repository;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;

public abstract class Repository<T, U> implements IRepository<T, U> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Class<T> type;

    @Autowired
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Repository() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T save(T t) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(t);
        session.getTransaction().commit();
        session.close();
        return t;
    }

    @Override
    public T findById(U id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("From " + type.getTypeName() + " t where t.id =:id");
        query.setParameter("id", id);
        T t = (T) query.uniqueResult();
        return t;
    }

    @Override
    public Boolean delete(T t) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Boolean result = Boolean.FALSE;
        try {
            session.delete(t);
            session.getTransaction().commit();
            session.close();
            result = Boolean.TRUE;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Set<T> findAll() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from " + type.getTypeName());
        Set<T> ts = new HashSet<>(query.list());
        return ts;
    }

    @Override
    public T update(T t) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(t);
        session.getTransaction().commit();
        session.close();
        return t;
    }
}

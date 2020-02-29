package ru.vlsu.animalSpecification.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.vlsu.animalSpecification.domain.Region;
import ru.vlsu.animalSpecification.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class RegionDAO {
    public Region findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Region.class, id);
    }

    public void save(Region region) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(region);
        tx1.commit();
        session.close();
    }

    public void update(Region region) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(region);
        tx1.commit();
        session.close();
    }

    public void delete(Region region) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(region);
        tx1.commit();
        session.close();
    }

    public List<Region> findAll() {
        List<Region> users = (List<Region>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Region").list();
        return users;
    }
}

package weather.application.location;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import weather.application.HibernateUtils;

import java.util.List;

public class LocationRepository {   // warstwa danych

    public Location saveNewLocation(Location location) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(location);

        transaction.commit();
        session.close();

        return location;
    }

    public List<Location> readAllLocationsSaved() {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Location> result = session.createQuery("FROM Location").getResultList();

        transaction.commit();
        session.close();

        return result;
    }
}

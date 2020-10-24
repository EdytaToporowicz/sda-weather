package weather.application.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import weather.application.HibernateUtils;


public class WeatherRepository {        // warstwa danych

    public Weather saveWeather(Weather weather) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(weather);

        transaction.commit();
        session.close();

        return weather;
    }
}

package weather.application.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import weather.application.HibernateUtils;


public class WeatherRepository {        // warstwa danych

    public WeatherRequest getWeatherParameters(WeatherRequest weatherRequest) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(weatherRequest);

        transaction.commit();
        session.close();

        return weatherRequest;
    }


    public WeatherResponse saveWeatherResponse(WeatherResponse weatherResponse) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(weatherResponse);

        transaction.commit();
        session.close();

        return weatherResponse;
    }
}

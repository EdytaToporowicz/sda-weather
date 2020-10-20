package weather.application.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import weather.application.HibernateUtils;

import java.util.Collections;
import java.util.List;

public class WeatherRepository {        // warstwa danych

        public WeatherParameters saveWeatherParameters(WeatherParameters weatherParameters) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(weatherParameters);

        transaction.commit();
        session.close();

        return weatherParameters;
    }



}

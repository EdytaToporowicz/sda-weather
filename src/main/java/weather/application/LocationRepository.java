package weather.application;

import org.hibernate.SessionFactory;

import java.util.Collections;
import java.util.List;

public class LocationRepository {   // warstwa danych

    private final SessionFactory sessionFactory;

    public LocationRepository() {
        // todo: add the hibernate configuration

        sessionFactory = null;
    }

    public Location saveNewLocation(Location location) {
        return location;
    }

    public List<Location> readAllLocationsSaved() {
        return Collections.emptyList();
    }
}

package weather.application.location;


import org.junit.jupiter.api.Test;
import weather.application.exceptions.BadRequestException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocationServiceTest {

   LocationService locationService = new LocationService();

    @Test
    void addNewLocation_shouldReturnNewLocation() {
        // when
        Location location = locationService.addNewLocation("city", 0, 0, "region", "country");

        // then
        assertEquals(location.getName(), "city");
        assertEquals(location.getCountry(), "country");
        assertEquals(location.getRegion(), "region");
        assertEquals(location.getLon(), 0);
        assertEquals(location.getLat(), 0);
    }

    @Test
    void addNewLocation_whenRegionIsEmpty_shouldReturnNewLocation() {
        // when
        Location location = locationService.addNewLocation("city", 0, 0, "", "country");

        // then
        assertEquals(location.getName(), "city");
        assertEquals(location.getCountry(), "country");
        assertEquals(location.getRegion(), "");
        assertEquals(location.getLon(), 0);
        assertEquals(location.getLat(), 0);
    }

    @Test
    void addNewLocation_whenCityIsEmpty_shouldThrowException() {
        // when
        assertThrows(BadRequestException.class, () -> locationService.addNewLocation(" ", 0, 0, "region", "country"));
    }

    @Test
    void addNewLocation_whenLongitudeIsAbove180_shouldThrowException() {
        // when
        assertThrows(BadRequestException.class, () -> locationService.addNewLocation("city", 0, 181, "region", "country"));
    }
}


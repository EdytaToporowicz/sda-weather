package weather.application.location;

import org.junit.jupiter.api.Test;
import weather.application.exceptions.BadRequestException;
import weather.application.location.Location;
import weather.application.location.LocationService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocationServiceTest {

    private final LocationService locationService = new LocationService();

    @Test
    void addNewLocation_shouldReturnNewLocation() {
        // when
        Location location = locationService.addNewLocation("city", 0, 0, "region", "country");

        // then
        assertEquals(location.getCityName(), "city");
        assertEquals(location.getCountryName(), "country");
        assertEquals(location.getRegionName(), "region");
        assertEquals(location.getLongitude(), 0);
        assertEquals(location.getLatitude(), 0);
    }

    @Test
    void addNewLocation_whenRegionIsEmpty_shouldReturnNewLocation() {
        // when
        Location location = locationService.addNewLocation("city", 0, 0, "", "country");

        // then
        assertEquals(location.getCityName(), "city");
        assertEquals(location.getCountryName(), "country");
        assertEquals(location.getRegionName(), "");
        assertEquals(location.getLongitude(), 0);
        assertEquals(location.getLatitude(), 0);
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


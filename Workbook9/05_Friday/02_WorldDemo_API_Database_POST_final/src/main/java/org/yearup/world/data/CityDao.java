package org.yearup.world.data;

import org.yearup.world.models.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDao
{
    List<City> searchByCountry(String country);
    City getById(int id);

    City add(City city);
    void update(int id, City city) throws SQLException;
    void delete(int id) throws SQLException;
}

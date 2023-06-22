package org.yearup.world.data;

import org.yearup.world.models.City;

import java.util.List;

public interface CityDao
{
    List<City> searchByCountry(String country);
    City getById(int id);
}

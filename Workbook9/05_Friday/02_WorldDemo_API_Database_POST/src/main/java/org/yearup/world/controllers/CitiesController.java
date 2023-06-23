package org.yearup.world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.world.data.CityDao;
import org.yearup.world.models.City;

import java.util.List;

@RestController
public class CitiesController
{
    private CityDao dao;

    @Autowired
    public CitiesController(CityDao dao)
    {
        this.dao = dao;
    }

    // http://localhost:8080/cities  == default to USA
    // http://localhost:8080/cities?country=DEU
    @GetMapping(path="cities")
    public List<City> getAll(@RequestParam(defaultValue = "USA") String country)
    {
        return dao.searchByCountry(country);
    }

    @GetMapping(path = "cities/{id}")
    public City getById(@PathVariable int id)
    {
        var city = dao.getById(id);

        if(city == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id: " + id + " does not exist.");
        }

        return city;
    }
}

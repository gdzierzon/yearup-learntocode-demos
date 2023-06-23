package org.yearup.world.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    // add = POST
//    @RequestMapping(path="cities", method = RequestMethod.POST)
    @PostMapping(path="cities")
    @ResponseStatus(HttpStatus.CREATED) // returns 201
    public City addCity(@RequestBody City city)
    {
        var newCity = dao.add(city);
        return newCity;
    }

    @PutMapping(path = "cities/{id}")
    public void updateCity( @PathVariable int id,
                            @RequestBody City city)
    {
        // make sure that the city to be updated actually exists
        var currentCity = dao.getById(id);

        if(currentCity == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "That city does not exist.");
        }

        try
        {
            dao.update(id, city);
        }
        catch(Exception ex)
        {}
    }

    @DeleteMapping(path = "cities/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // returns 204
    public void deleteCity(@PathVariable int id)
    {
        // make sure that the city to be deleted actually exists
        var city = dao.getById(id);

        if(city == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "That city does not exist.");
        }

        try
        {
            dao.delete(id);
        }
        catch(Exception ex)
        {}
    }

}

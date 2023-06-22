package org.yearup.world.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.world.models.City;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CitiesController
{
    private List<City> cities;

    public CitiesController()
    {
        cities = new ArrayList<>();

        cities.add(new City()
        {{
            setId(123);
            setName("Dallas");
            setCountry("USA");
            setState("TX");
            setPopulation(1188580);
        }});

        cities.add(new City()
        {{
            setId(2687);
            setName("Grantsville");
            setCountry("USA");
            setState("UT");
            setPopulation(13000);
        }});

        cities.add(new City()
        {{
            setId(1354);
            setName("Freiberg");
            setCountry("GER");
            setState("SAX");
            setPopulation(1296123);
        }});
    }

    // http://localhost:8080/cities
    @GetMapping(path="cities")
    public List<City> getAll()
    {
        return cities;
    }

    @GetMapping(path = "cities/{id}")
    public City getById(@PathVariable int id)
    {
        var city =  cities.stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        if(city.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The id: " + id + " does not exist.");
        }

        return city.get();
    }
}

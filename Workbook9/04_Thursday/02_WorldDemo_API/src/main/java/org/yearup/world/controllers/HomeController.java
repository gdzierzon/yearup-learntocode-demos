package org.yearup.world.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController
{
    // http://localhost:8080
    // http://localhost:8080?country=Germany
    @GetMapping(path = "")
    public String getGreeting(@RequestParam(required = false) String country)
    {
        if(country == null)
        {
            return "Hello World!";
        }

        return "Hello " + country;
    }

//    @GetMapping(path = "greetings/hello")
    @RequestMapping(path = "greetings/hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam(required = false) String name)
    {
        return "Hello " + name;
    }


    @GetMapping(path = "greetings/morning")
    public String sayGoodMorning()
    {
        return "Good Morning";
    }
}

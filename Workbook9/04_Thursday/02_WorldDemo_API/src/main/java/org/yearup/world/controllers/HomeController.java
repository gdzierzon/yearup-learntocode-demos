package org.yearup.world.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController
{
    @GetMapping(path = "")
    public String getGreeting()
    {
        return "Hello World!";
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

package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yearup.data.UserDao;
import org.yearup.models.User;

import java.security.Principal;

@RestController
@CrossOrigin
@RequestMapping("demo")
public class DemoController
{
    private UserDao userDao;

    @Autowired
    public DemoController(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("")
    public String getGreeting()
    {
        return "Hello World";
    }

    // you have to be logged in
    @PreAuthorize("isAuthenticated()")
    @GetMapping("secured")
    public String getUserName(Principal principal) // Principal = name tag
    {
        return "Hello " + principal.getName();
    }

    // you must be an ADMIN
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("admin")
    public String getAdminId(Principal principal) // principal = name tag
    {
        User user = userDao.getByUserName(principal.getName());

        return user.getId() + ": " + user.getUsername() + " [" + user.getRole() + "]";
    }


}

package org.yearup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.yearup.data.RegistrationDao;

@Component
public class Application implements CommandLineRunner
{
//    // property injection
//    @Autowired
//    private DataSource dataSource;

    private RegistrationDao dao;

    @Autowired
    public Application(RegistrationDao dao)
    {
        this.dao = dao;
    }

    @Override
    public void run(String... args) throws Exception
    {
//        dao.register(null);
    }
}

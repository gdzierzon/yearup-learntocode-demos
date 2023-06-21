package org.yearup.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig
{
    private DataSource dataSource;

    @Bean
    public DataSource dataSource()
    {
        return dataSource;
    }

    @Bean
    public String defaultFirstName()
    {
        return "Gregor";
    }

    @Bean
    public String defaultLastName()
    {
        return "Dzierzon";
    }

    @Autowired
    public AppConfig(@Value("${datasource.url}") String url,
                     @Value("${datasource.username}") String username,
                     @Value("${datasource.password}") String password)
    {
        dataSource = new BasicDataSource()
        {{
            setUrl(url);
            setUsername(username);
            setPassword(password);
        }};

        System.out.println(url);
        System.out.println(username);
        System.out.println(password);

    }
}

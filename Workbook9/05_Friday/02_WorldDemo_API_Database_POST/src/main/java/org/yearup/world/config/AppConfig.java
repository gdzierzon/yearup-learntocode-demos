package org.yearup.world.config;

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
        return this.dataSource;
    }

    @Autowired
    public AppConfig(@Value("${database.url}") String url,
                     @Value("${database.username}") String username,
                     @Value("${database.password}") String password)
    {
        dataSource = new BasicDataSource()
        {{
            setUrl(url);
            setUsername(username);
            setPassword(password);
        }};
    }
}

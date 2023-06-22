package org.yearup.world.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yearup.world.models.City;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCityDao implements CityDao
{
    private DataSource dataSource;

    @Autowired
    public MySqlCityDao(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public List<City> searchByCountry(String country)
    {
        List<City> cities = new ArrayList<>();

        String sql = """
                SELECT ID
                    , Name
                    , CountryCode
                    , District
                    , Population
                FROM city
                WHERE CountryCode = ?;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setString(1, country);

            ResultSet row = statement.executeQuery();

            // use WHILE when you expect multiple rows
            while (row.next())
            {
                int id = row.getInt("ID");
                String name = row.getString("Name");
                String countryCode = row.getString("CountryCode");
                String state = row.getString("District");
                int population = row.getInt("Population");

                City product = new City()
                {{
                    setId(id);
                    setName(name);
                    setCountry(countryCode);
                    setState(state);
                    setPopulation(population);
                }};

                cities.add(product);
            }

        }
        catch (SQLException e)
        {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }

        return cities;

    }

    @Override
    public City getById(int cityId)
    {
        String sql = """
                SELECT ID
                    , Name
                    , CountryCode
                    , District
                    , Population
                FROM city
                WHERE ID = ?;
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        )
        {
            statement.setInt(1, cityId);

            ResultSet row = statement.executeQuery();

            // use WHILE when you expect multiple rows
            while (row.next())
            {
                int id = row.getInt("ID");
                String name = row.getString("Name");
                String country = row.getString("CountryCode");
                String state = row.getString("District");
                int population = row.getInt("Population");

                City city = new City()
                {{
                    setId(id);
                    setName(name);
                    setCountry(country);
                    setState(state);
                    setPopulation(population);
                }};

                return city;
            }

        }
        catch (SQLException e)
        {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
        }

        return null;
    }
}

package ru.sibadi.demowebapp.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.sibadi.demowebapp.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PersonRepository {
    private final JdbcTemplate jdbcTemplate;

    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAllPersons() {
        return jdbcTemplate.query("SELECT * FROM PERSONS", new PersonMapper());
    }

    public Person findPersonById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PERSONS WHERE ID="+id, new PersonMapper());
    }

    public void addPerson(int id, String name, int salary) {
        jdbcTemplate.update("INSERT INTO PERSONS  (NAME,SALARY) VALUES ('" + name +  "', " + salary +  ")");
    }

    public static class PersonMapper implements RowMapper<Person>
    {
        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person p = new Person(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("salary") );
            return p;
        }
    }
}

package ru.sibadi.demowebapp.repository;

import org.springframework.stereotype.Repository;
import ru.sibadi.demowebapp.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    private final List<Person> persons = new ArrayList<>();

    public PersonRepository() {
        persons.add(new Person(1, "Тауберт П.И.", 10000));
    }

    public List<Person> findAllPersons() {
        return persons;
    }

    public Person findPersonById(int id) {
        Person foundPerson = null;
        for (Person p : persons) {
            if (p.getId() == id) {
                foundPerson = p;
            }
        }
        return foundPerson;
    }

    public void addPerson(int id, String name, int salary) {
        persons.add(new Person(id, name, salary));
    }
}

package ru.murza.artif.dao;

import org.springframework.stereotype.Component;
import ru.murza.artif.models.Person;

import java.util.ArrayList;

@Component
public class PersonDAO {
    private static int COUNTER;
    private ArrayList<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++COUNTER, "Tom"));
        people.add(new Person(++COUNTER, "Bob"));
        people.add(new Person(++COUNTER, "Mike"));
    }

    public ArrayList<Person> index(){
        return people;
    }

    public Person show (int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}

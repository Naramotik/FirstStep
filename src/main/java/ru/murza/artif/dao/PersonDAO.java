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
    public void save(Person person){
        person.setId(++COUNTER);
        people.add(person);
    }
    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());

    }
    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}

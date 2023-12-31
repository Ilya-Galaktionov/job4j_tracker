package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> hasName = x -> x.getName().contains(key);
        Predicate<Person> hasSurname = x -> x.getSurname().contains(key);
        Predicate<Person> hasPhone = x -> x.getPhone().contains(key);
        Predicate<Person> hasAddress = x -> x.getAddress().contains(key);
        Predicate<Person> combine = hasName.or(hasSurname).or(hasPhone).or(hasAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
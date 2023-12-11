package ru.job4j.search;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

class PhoneDictionaryTest {
    @Test
    void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    void whenFindIsEmpty() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Ilya");
        assertThat(persons).isEmpty();
    }
}
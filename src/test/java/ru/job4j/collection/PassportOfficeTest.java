package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PassportOfficeTest {
    @Test
    void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    void whenCheckDuplicate() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen anotherCitizen = new Citizen("2f44a", "Petr");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.add(anotherCitizen)).isFalse();
    }
}
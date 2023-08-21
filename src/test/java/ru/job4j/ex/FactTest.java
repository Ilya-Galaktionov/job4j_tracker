package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Fact fact = new Fact();
                    fact.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    void when4then24() {
        int expected = 24;
        int result = new Fact().calc(4);
        assertThat(result).isEqualTo(expected);
    }
}
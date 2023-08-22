package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultiValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "3", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int two = input.askInt("Enter menu:");
        assertThat(two).isEqualTo(2);
        int three = input.askInt("Enter menu:");
        assertThat(three).isEqualTo(3);
        int four = input.askInt("Enter menu:");
        assertThat(four).isEqualTo(4);
    }

    @Test
    void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}

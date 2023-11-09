package christmas.view.input;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

class DateTest {
    @Test
    public void checkInvalidInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Date(32));
    }
}
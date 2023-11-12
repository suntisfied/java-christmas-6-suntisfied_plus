package christmas.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateInputTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    String mockInput = "date\n99\n3";

    @BeforeEach
    public void setUpStreams() {
        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));
        System.setOut(new PrintStream(outputStream));

    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(System.in);
        System.setOut(System.out);
        Console.close();
    }

    @Test
    public void askInputUntilCorrect() {
        DateInput dateInput = new DateInput();

        try {
            dateInput.askDate();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]", "3");
    }
}
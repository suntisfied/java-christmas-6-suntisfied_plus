package christmas.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.Messages;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderInputTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
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
        String mockInput =
                """
                해산물파스타-20,레드와인-10,초코케이크-10
                레드와인-1
                해산물파스타-2,레드와인-1,초코케이크-1
                """;

        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        OrderInput orderInput = new OrderInput();

        try {
            orderInput.askOrder();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("[ERROR]", "해산물파스타-2,레드와인-1,초코케이크-1");
    }

    @Test
    public void acceptOrderWithWhiteSpace() {
        String mockInput = "해산물파스타 - 2,  레드와인 - 1,  초코케이크 - 1";

        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        OrderInput orderInput = new OrderInput();

        try {
            orderInput.askOrder();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains("해산물파스타-2,레드와인-1,초코케이크-1");
    }

    @Test
    public void checkInvalidOrderInputFormats() {
        String mockInput =
                """
                해산물파스타-2레드와인-1,초코케이크-1
                해산물파스타2,레드와인-1,초코케이크-1
                해산물파스타-,레드와인-1,초코케이크-1
                """;

        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        OrderInput orderInput = new OrderInput();

        try {
            orderInput.askOrder();
        } catch (NoSuchElementException ignored) {
        }

        assertThat(outputStream.toString()).contains(Messages.ERROR_INVALID_FORMAT.getMessage());
    }

    @Test
    public void checkInvalidMenu() {
        String mockInput = "토마토파스타-1";

        System.setIn(new ByteArrayInputStream(mockInput.getBytes()));

        OrderInput orderInput = new OrderInput();

        try {
            orderInput.askOrder();
        } catch (NoSuchElementException ignored) {
        }

        System.out.println("outputStream: " + outputStream);

        assertThat(outputStream.toString()).contains(Messages.ERROR_NOT_IN_MENU.getMessage());
    }
}
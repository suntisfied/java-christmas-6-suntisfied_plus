package christmas.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.view.Messages;
import java.util.function.Predicate;

public class DateInput {
    public Date askDate() {
        System.out.println(Messages.DATE_INPUT_INSTRUCTION.getMessage());

        String input;
        do {
            input = readLine();
        } while (validate(input));

        int convertedInput = Integer.parseInt(input);

        return new Date(convertedInput);
    }

    private boolean validate(String input) {
        boolean isInvalid = false;
        try {
            checkValidity(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isInvalid = true;
        }
        return isInvalid;
    }

    private void checkValidity(String input) {
        if (!isPositiveInteger.test(input)) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_POSITIVE_INTEGER.getMessage());
        }
        if (!isValidDate.test(input)) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_VALID_DATE.getMessage());
        }
    }

    private final Predicate<String> isValidDate = input -> {
      int date = Integer.parseInt(input);
        return date >= 1 && date <= 31;
    };

    private final Predicate<String> isPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    };
}

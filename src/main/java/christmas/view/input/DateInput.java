package christmas.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.promotion.Defaults.INITIAL_DAY_OF_MONTH;
import static christmas.promotion.Defaults.LAST_DAY_OF_MONTH;

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
        if (isNonPositiveInteger.test(input) || isInvalidDate.test(input)) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_DATE.getMessage());
        }
    }

    private final Predicate<String> isInvalidDate = input -> {
      int date = Integer.parseInt(input);
        return date < INITIAL_DAY_OF_MONTH.getNumber() || date > LAST_DAY_OF_MONTH.getNumber();
    };

    private final Predicate<String> isNonPositiveInteger = input -> {
        try {
            return Integer.parseInt(input) < 0;
        } catch (NumberFormatException e) {
            return true;
        }
    };
}

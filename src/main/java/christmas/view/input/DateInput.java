package christmas.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.view.Messages;

public class DateInput extends DateInputChecker {
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
}

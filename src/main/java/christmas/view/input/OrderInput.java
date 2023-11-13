package christmas.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.view.Messages;

public class OrderInput extends OrderInputChecker {
    public Order askOrder() {
        System.out.println(Messages.INTRODUCTION.getMessage());
        System.out.println(Messages.ORDER_INPUT_INSTRUCTION.getMessage());

        String input;
        do {
            input = readLine();
            input = removeWhiteSpaces(input);
        } while (validate(input));

        return new Order(input);
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

    private String removeWhiteSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }
}

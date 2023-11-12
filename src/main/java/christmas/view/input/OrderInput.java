package christmas.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.order.OrderVolume;
import christmas.order.VolumeCalculator;
import christmas.order.converter.Converter;
import christmas.order.converter.Separator;
import christmas.order.menu.Category;
import christmas.order.menu.Menu;
import christmas.view.Messages;
import java.util.List;
import java.util.function.Predicate;

public class OrderInput {
    public Order askOrder() {
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

    private void checkValidity(String input) {
        boolean validInput = false;

        if (isInvalidFormat.test(new Order(input))) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_FORMAT.getMessage());
        }
        if (isNotInMenu.test(new Order(input))) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_IN_MENU.getMessage());
        }

        if (!isInvalidFormat.test(new Order(input)) && !isNotInMenu.test(new Order(input))) {
            validInput = true;
        }

        if (validInput) {
            if (isOnlyDrinkOrder.test(new Order(input))) {
                throw new IllegalArgumentException(Messages.ERROR_ONLY_DRINK_ORDER.getMessage());
            }
            if (isOverOrderLimit.test(new Order(input))) {
                throw new IllegalArgumentException(Messages.ERROR_OVER_ORDER_AMOUNT_LIMIT.getMessage());
            }
        }
    }

    private final Predicate<Order> isNotInMenu = order -> {
        Converter converter = new Converter();
        List<Menu> orderedMenuNames = converter.createOrderedMenuNameList(order);
        return orderedMenuNames.contains(null);
    };

    private final Predicate<Order> isInvalidFormat = order -> {
        Separator separator = new Separator();
        List<String> MenuAndAmounts = separator.createMenuNameAndAmounts(order);

        List<String> convertibleMembers = MenuAndAmounts.stream()
                .filter(OrderInput::isConvertibleToInt)
                .toList();

        int orderedMenuNumber = MenuAndAmounts.size() - convertibleMembers.size();
        int orderedAmountNumber = convertibleMembers.size();

        return orderedMenuNumber != orderedAmountNumber;
    };

    private static boolean isConvertibleToInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private final Predicate<Order> isOnlyDrinkOrder = order -> {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        OrderVolume totalVolume = volumeCalculator.calculateTotalOrderVolume(order);
        OrderVolume drinkVolume = volumeCalculator.calculateOrderVolumeByCategory(order, Category.DRINK);
        return totalVolume.equals(drinkVolume);
    };

    private final Predicate<Order> isOverOrderLimit = order -> {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        return volumeCalculator.calculateTotalOrderVolume(order).volume() > 20;
    };

    private String removeWhiteSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }
}

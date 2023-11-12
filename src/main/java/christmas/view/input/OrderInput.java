package christmas.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.order.OrderVolume;
import christmas.order.VolumeCalculator;
import christmas.order.menu.Category;
import java.util.function.Predicate;

public class OrderInput {
    public Order askOrder() {
        System.out.println(Messages.ORDER_INPUT_INSTRUCTION.getMessage());

        String input;
        do {
            input = readLine();
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
        if (isOnlyDrinkOrder.test(new Order(input))) {
            throw new IllegalArgumentException(Messages.ERROR_ONLY_DRINK_ORDER.getMessage());
        }
        if (isOverOrderLimit.test(new Order(input))) {
            throw new IllegalArgumentException(Messages.ERROR_OVER_ORDER_AMOUNT_LIMIT.getMessage());
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
}

package christmas.order.converter;

import christmas.order.menu.Menu;
import christmas.order.menu.OrderAmount;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Extractor {
    HashMap<Menu, OrderAmount> createMenus(List<String> menuNameAndAmounts) {
        HashMap<Menu, OrderAmount> menus = new HashMap<>();

        List<String> orderedMenuNames = extractNames(menuNameAndAmounts);
        List<Integer> orderedMenuAmounts = extractAmounts(menuNameAndAmounts);

        for (int i = 0; i < orderedMenuNames.size(); i++) {
            Menu convertedMenuName = new Converter().convertInputToMenu(orderedMenuNames.get(i));
            OrderAmount convertedOrderAmount = new OrderAmount(orderedMenuAmounts.get(i));
            menus.put(convertedMenuName, convertedOrderAmount);
        }

        return menus;
    }

    private List<String> extractNames(List<String> menuNameAndNumbers) {
        return menuNameAndNumbers.stream()
                .filter(i -> !isNumeric.test(i))
                .toList();
    }

    private List<Integer> extractAmounts(List<String> menuNameAndNumbers) {
        return menuNameAndNumbers.stream()
                .filter(isNumeric)
                .map(Integer::parseInt)
                .toList();
    }

    private final Predicate<String> isNumeric = input -> {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    };
}

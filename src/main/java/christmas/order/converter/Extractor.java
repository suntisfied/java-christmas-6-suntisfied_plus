package christmas.order.converter;

import christmas.order.menuitem.Menu;
import christmas.order.MenuAmount;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Extractor {
    HashMap<Menu, MenuAmount> createMenus(List<String> menuNameAndAmounts) {
        HashMap<Menu, MenuAmount> menus = new HashMap<>();

        List<String> orderedMenuNames = extractNames(menuNameAndAmounts);
        List<Integer> orderedMenuAmounts = extractAmounts(menuNameAndAmounts);

        for (int i = 0; i < orderedMenuNames.size(); i++) {
            Menu convertedMenuName = new MenuConverter().convertInputToMenu(orderedMenuNames.get(i));
            MenuAmount convertedMenuAmount = new MenuAmount(orderedMenuAmounts.get(i));
            menus.put(convertedMenuName, convertedMenuAmount);
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

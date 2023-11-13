package christmas.order.converter;

import christmas.order.Volume;
import christmas.order.menu.Menu;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Extractor {
    HashMap<Menu, Volume> createMenus(List<String> menuNameAndAmounts) {
        HashMap<Menu, Volume> menus = new HashMap<>();

        List<String> orderedMenuNames = extractNames(menuNameAndAmounts);
        List<Integer> orderedMenuAmounts = extractAmounts(menuNameAndAmounts);

        for (int i = 0; i < orderedMenuNames.size(); i++) {
            Menu convertedMenuName = Menu.convertNameToMenu(orderedMenuNames.get(i));
            Volume convertedVolume = new Volume(orderedMenuAmounts.get(i));
            menus.put(convertedMenuName, convertedVolume);
        }

        return menus;
    }

    List<String> extractNames(List<String> menuNameAndNumbers) {
        return menuNameAndNumbers.stream()
                .filter(i -> !isNumeric.test(i))
                .toList();
    }

    List<Integer> extractAmounts(List<String> menuNameAndNumbers) {
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

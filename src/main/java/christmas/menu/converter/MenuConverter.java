package christmas.menu.converter;

import christmas.menu.Appetizers;
import christmas.menu.Desserts;
import christmas.menu.Drinks;
import christmas.menu.MainDishes;
import christmas.menu.Menu;
import christmas.menu.MenuAmount;
import christmas.menu.MenuTable;
import christmas.menu.Ordered;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class MenuConverter {
    public Ordered createOrderedMenus(String inputs) {
        HashMap<Menu, MenuAmount> menus = new HashMap<>();

        List<String> menuNameAndAmountsWithDash = splitInputsByComma(inputs);
        List<String> menuNameAndAmounts = new ArrayList<>();

        for (String menuNameAndAmountWithDash : menuNameAndAmountsWithDash) {
            List<String> currentMenuNameAndAmounts = splitInputsByDash(menuNameAndAmountWithDash);
            menuNameAndAmounts.addAll(currentMenuNameAndAmounts);
        }

        List<String> orderedMenuNames = extractNames(menuNameAndAmounts);
        List<Integer> orderedMenuAmounts = extractAmounts(menuNameAndAmounts);

        for (int i = 0; i < orderedMenuNames.size(); i++) {
            Menu convertedMenuName = convertInputToMenu(orderedMenuNames.get(i));
            MenuAmount convertedMenuAmount = new MenuAmount(orderedMenuAmounts.get(i));
            menus.put(convertedMenuName, convertedMenuAmount);
        }

        return new Ordered(menus);
    }

    private List<String> extractNames(List<String> menuNameAndNumbers) {
        return menuNameAndNumbers.stream()
                .filter(i -> !isNumeric.test(i))
                .toList();
    }

    private List<Integer> extractAmounts(List<String> menuNameAndNumbers) {
        return menuNameAndNumbers.stream()
                .filter(i -> isNumeric.test(i))
                .map(Integer::parseInt)
                .toList();
    }

    Predicate<String> isNumeric = input -> {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    };

    private List<String> splitInputsByDash(String inputs) {
        return Arrays.asList(inputs.split("-"));
    }

    private List<String> splitInputsByComma(String inputs) {
        return Arrays.asList(inputs.split(","));
    }

    public Menu convertInputToMenu(String input) {
        MenuTable menuTable = createMenuTable();

        return menuTable.menuTable().get(input);
    }

    private MenuTable createMenuTable() {
        HashMap<String, Menu> menuTable = new HashMap<>();

        menuTable.put("양송이수프", Appetizers.MUSHROOM_CREAM_SOUP);
        menuTable.put("타바스", Appetizers.TAPAS);
        menuTable.put("시저샐러드", Appetizers.CAESAR_SALAD);
        menuTable.put("티본스테이크", MainDishes.T_BONE_STEAK);
        menuTable.put("바비큐립", MainDishes.BARBECUE_RIBS);
        menuTable.put("해산물파스타", MainDishes.SEAFOOD_PASTA);
        menuTable.put("크리스마스파스타", MainDishes.CHRISTMAS_PASTA);
        menuTable.put("초코케이크", Desserts.CHOCOLATE_CAKE);
        menuTable.put("아이스크림", Desserts.ICE_CREAM);
        menuTable.put("제로콜라", Drinks.ZERO_COLA);
        menuTable.put("레드와인", Drinks.RED_WINE);
        menuTable.put("샴페인", Drinks.CHAMPAGNE);

        return new MenuTable(menuTable);
    }
}

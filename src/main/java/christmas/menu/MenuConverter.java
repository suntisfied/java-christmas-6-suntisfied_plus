package christmas.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MenuConverter {
    public Ordered createOrderedMenus(String inputs) {
        List<Menu> orderedMenus = new ArrayList<>();

        List<String> convertedInputs = convertInputs(inputs);
        for (String convertedInput : convertedInputs) {
            orderedMenus.add(convertInputToMenu(convertedInput));
        }

        return new Ordered(orderedMenus);
    }

    private List<String> convertInputs(String inputs) {
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

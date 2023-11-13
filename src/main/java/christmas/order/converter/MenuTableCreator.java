package christmas.order.converter;

import christmas.order.menu.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuTableCreator {
    MenuTable createMenuTable() {
        List<Menu> menus = List.of(Menu.values());

        List<String> menuNames = new ArrayList<>();
        for (Menu menu : menus) {
            menuNames.add(menu.getName());
        }

        Map<String, Menu> menuTable = new HashMap<>();
        for (int i = 0; i < menuNames.size(); i++) {
            menuTable.put(menuNames.get(i), menus.get(i));
        }

        return new MenuTable(menuTable);
    }
}

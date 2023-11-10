package christmas.menu.converter;

import christmas.menu.menuitem.Menu;
import christmas.menu.MenuAmount;
import christmas.menu.MenuTable;
import christmas.menu.Ordered;
import java.util.HashMap;
import java.util.List;

public class MenuConverter {
    private final Extractor extractor;
    private final Separator separator;
    private final MenuTableCreator menuTableCreator;

    public MenuConverter() {
        extractor = new Extractor();
        separator = new Separator();
        menuTableCreator = new MenuTableCreator();
    }

    public Ordered createOrderedMenus(String inputs) {
        List<String> menuNameAndAmounts = separator.createMenuNameAndAmounts(inputs);
        HashMap<Menu, MenuAmount> menus = extractor.createMenus(menuNameAndAmounts);

        return new Ordered(menus);
    }

    Menu convertInputToMenu(String input) {
        MenuTable menuTable = menuTableCreator.createMenuTable();

        return menuTable.menuTable().get(input);
    }
}

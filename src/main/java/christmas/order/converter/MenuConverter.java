package christmas.order.converter;

import christmas.order.menuitem.Menu;
import christmas.order.MenuAmount;
import christmas.order.MenuTable;
import christmas.order.OrderedMenuTotal;
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

    public OrderedMenuTotal createOrderedMenuTotal(String inputs) {
        List<String> menuNameAndAmounts = separator.createMenuNameAndAmounts(inputs);
        HashMap<Menu, MenuAmount> orderedMenuTotal = extractor.createMenus(menuNameAndAmounts);

        return new OrderedMenuTotal(orderedMenuTotal);
    }

    Menu convertInputToMenu(String input) {
        MenuTable menuTable = menuTableCreator.createMenuTable();

        return menuTable.menuTable().get(input);
    }
}

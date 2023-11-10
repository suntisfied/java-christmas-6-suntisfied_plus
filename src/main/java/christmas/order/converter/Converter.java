package christmas.order.converter;

import christmas.order.menu.Menu;
import christmas.order.menu.OrderAmount;
import christmas.order.OrderedMenuTotal;
import java.util.HashMap;
import java.util.List;

public class Converter {
    private final Extractor extractor;
    private final Separator separator;
    private final MenuTableCreator menuTableCreator;

    public Converter() {
        extractor = new Extractor();
        separator = new Separator();
        menuTableCreator = new MenuTableCreator();
    }

    public OrderedMenuTotal createOrderedMenuTotal(String inputs) {
        List<String> menuNameAndAmounts = separator.createMenuNameAndAmounts(inputs);
        HashMap<Menu, OrderAmount> orderedMenuTotal = extractor.createMenus(menuNameAndAmounts);

        return new OrderedMenuTotal(orderedMenuTotal);
    }

    Menu convertInputToMenu(String input) {
        MenuTable menuTable = menuTableCreator.createMenuTable();

        return menuTable.menuTable().get(input);
    }
}

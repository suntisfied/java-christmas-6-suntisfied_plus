package christmas.order.converter;

import christmas.order.menu.Menu;
import christmas.order.OrderAmount;
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

    public HashMap<String, Integer> createExtractedNameAndAmounts(String input) {
        HashMap<String, Integer> extractedNameAndAmounts = new HashMap<>();

        List<String> menuNameAndNumbers = separator.createMenuNameAndAmounts(input);

        List<String> extractNames = extractor.extractNames(menuNameAndNumbers);
        List<Integer> extractAmounts = extractor.extractAmounts(menuNameAndNumbers);

        for (int i = 0; i < extractNames.size(); i++) {
            extractedNameAndAmounts.put(extractNames.get(i), extractAmounts.get(i));
        }

        return extractedNameAndAmounts;
    }

    Menu convertInputToMenu(String input) {
        MenuTable menuTable = menuTableCreator.createMenuTable();

        return menuTable.menuTable().get(input);
    }
}

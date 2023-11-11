package christmas.order.converter;

import christmas.order.OrderVolume;
import christmas.order.OrderWithVolume;
import christmas.order.menu.Menu;
import christmas.view.input.Order;
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

    public OrderWithVolume createOrderedMenuTotal(Order order) {
        List<String> menuNameAndAmounts = separator.createMenuNameAndAmounts(order);
        HashMap<Menu, OrderVolume> orderedMenuTotal = extractor.createMenus(menuNameAndAmounts);

        return new OrderWithVolume(orderedMenuTotal);
    }

    public List<Menu> createOrderedMenuNameList(Order order) {
        return createOrderedMenuTotal(order).orderedMenuTotal().keySet().stream().toList();
    }

    public HashMap<String, Integer> createExtractedNameAndAmounts(Order order) {
        HashMap<String, Integer> extractedNameAndAmounts = new HashMap<>();

        List<String> menuNameAndNumbers = separator.createMenuNameAndAmounts(order);

        List<String> extractNames = extractor.extractNames(menuNameAndNumbers);
        List<Integer> extractAmounts = extractor.extractAmounts(menuNameAndNumbers);

        for (int i = 0; i < extractNames.size(); i++) {
            extractedNameAndAmounts.put(extractNames.get(i), extractAmounts.get(i));
        }

        return extractedNameAndAmounts;
    }

    Menu convertOrderToMenu(String rawOrder) {
        MenuTable menuTable = menuTableCreator.createMenuTable();

        return menuTable.menuTable().get(rawOrder);
    }
}

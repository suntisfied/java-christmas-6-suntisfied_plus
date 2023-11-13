package christmas.order.converter;

import christmas.order.TotalOrder;
import christmas.order.Volume;
import christmas.order.menu.Menu;
import christmas.view.input.Order;
import java.util.HashMap;
import java.util.List;

public class Converter {
    private final Extractor extractor;
    private final Separator separator;

    public Converter() {
        extractor = new Extractor();
        separator = new Separator();
    }

    public TotalOrder createTotalOrder(Order order) {
        List<String> menuNameAndAmounts = separator.createMenuNameAndAmounts(order);
        HashMap<Menu, Volume> orderedMenuTotal = extractor.createMenus(menuNameAndAmounts);

        return new TotalOrder(orderedMenuTotal);
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
}

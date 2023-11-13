package christmas.order.converter;

import christmas.order.TotalOrder;
import christmas.order.Volume;
import christmas.order.menu.Menu;
import christmas.view.input.Order;
import java.util.List;
import java.util.Map;

public class Converter {
    private final Extractor extractor;
    private final Separator separator;

    public Converter() {
        extractor = new Extractor();
        separator = new Separator();
    }

    public TotalOrder convertToTotalOrder(Order order) {
        List<String> menuNameAndVolumes = separator.createMenuNameAndVolumes(order);
        Map<Menu, Volume> orderedMenuTotal = extractor.createMenus(menuNameAndVolumes);

        return new TotalOrder(orderedMenuTotal);
    }
}

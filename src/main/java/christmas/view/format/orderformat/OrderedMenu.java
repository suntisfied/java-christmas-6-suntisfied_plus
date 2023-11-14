package christmas.view.format.orderformat;

import christmas.converter.Converter;
import christmas.order.TotalOrder;
import christmas.order.menu.Menu;
import christmas.view.Messages;
import christmas.view.format.BlankLineRemover;
import christmas.view.input.Order;
import java.util.List;

public class OrderedMenu implements OrderFormat {
    @Override
    public String format(Order order) {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(order);
        List<Menu> orderedMenuNames = totalOrder.produceOrderedMenus();

        StringBuilder orderedMenuTexts = new StringBuilder();
        for (Menu menu : orderedMenuNames) {
            orderedMenuTexts.append(menu.getName())
                    .append(" ")
                    .append(totalOrder.getVolumeByMenu(menu).volume())
                    .append(Messages.UNIT_COUNT.getMessage())
                    .append(System.lineSeparator());
        }
        orderedMenuTexts = new BlankLineRemover().remove(orderedMenuTexts, 1);
        return orderedMenuTexts.toString();
    }
}

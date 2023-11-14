package christmas.view.format.orderformat;

import christmas.converter.Converter;
import christmas.order.TotalOrder;
import christmas.order.menu.Menu;
import christmas.view.Messages;
import christmas.view.input.Order;
import java.util.List;

public class OrderedMenu implements OrderFormat {
    @Override
    public String format(Order order) {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(order);
        List<Menu> orderedMenuNames = totalOrder.produceOrderedMenus();

        StringBuilder stringBuilder = new StringBuilder();
        for (Menu menu : orderedMenuNames) {
            stringBuilder.append(menu.getName())
                    .append(" ")
                    .append(totalOrder.getVolumeByMenu(menu).volume())
                    .append(Messages.UNIT_COUNT.getMessage())
                    .append(System.lineSeparator());
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        return stringBuilder.toString();
    }
}

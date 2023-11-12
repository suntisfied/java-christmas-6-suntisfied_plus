package christmas.view.integration.orderformat;

import christmas.order.Volume;
import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.view.Messages;
import christmas.view.input.Order;
import java.util.HashMap;
import java.util.List;

public class OrderedMenu implements OrderFormat {
    @Override
    public String format(Order order) {
        Converter converter = new Converter();
        HashMap<Menu, Volume> orderedMenu = converter.createOrderedMenuTotal(order).orderedMenuTotal();
        List<Menu> orderedMenuNames = converter.createOrderedMenuNameList(order);

        StringBuilder stringBuilder = new StringBuilder();
        for (Menu menu : orderedMenuNames) {
            stringBuilder.append(menu.getName())
                    .append(" ")
                    .append(orderedMenu.get(menu).volume())
                    .append(Messages.UNIT_COUNT.getMessage())
                    .append("\r\n");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        return stringBuilder.toString();
    }
}

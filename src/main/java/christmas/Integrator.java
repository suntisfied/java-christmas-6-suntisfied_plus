package christmas;

import christmas.order.OrderVolume;
import christmas.order.TotalOrder;
import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.view.Messages;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class Integrator {
    NumberFormat numberFormatter;

    public Integrator() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    protected String formatOrderedMenu(Order order) {
        Converter converter = new Converter();
        HashMap<Menu, OrderVolume> orderedMenu = converter.createOrderedMenuTotal(order).orderedMenuTotal();
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

    protected String formatTotalCostBeforePromotion(Order order) {
        TotalOrder totalOrder = new TotalOrder(order);
        int totalOrderCost = totalOrder.calculateTotalOrderCost().price();

        return numberFormatter.format(totalOrderCost)
                + Messages.UNIT_CURRENCY.getMessage();
    }
}

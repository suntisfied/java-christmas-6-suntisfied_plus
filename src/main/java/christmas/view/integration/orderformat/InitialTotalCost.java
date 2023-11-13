package christmas.view.integration.orderformat;

import christmas.order.TotalOrder;
import christmas.order.converter.Converter;
import christmas.view.Messages;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.Locale;

public class InitialTotalCost implements OrderFormat {
    private final NumberFormat numberFormatter;

    public InitialTotalCost() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(Order order) {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(order);
        int totalOrderCost = totalOrder.calculateTotalCost().price();

        return numberFormatter.format(totalOrderCost)
                + Messages.UNIT_CURRENCY.getMessage();
    }
}

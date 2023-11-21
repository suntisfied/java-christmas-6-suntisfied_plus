package christmas.view.format.orderformat;

import christmas.order.TotalOrder;
import christmas.converter.Converter;
import christmas.view.Messages;
import christmas.view.input.MenuOrder;
import java.text.NumberFormat;
import java.util.Locale;

public class InitialTotalCost implements OrderFormat {
    private final NumberFormat numberFormatter;

    public InitialTotalCost() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(MenuOrder menuOrder) {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(menuOrder);
        int totalOrderCost = totalOrder.calculateTotalCost().amount();

        return numberFormatter.format(totalOrderCost)
                + Messages.UNIT_CURRENCY.getMessage();
    }
}

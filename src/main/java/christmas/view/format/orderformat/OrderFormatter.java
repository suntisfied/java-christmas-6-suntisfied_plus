package christmas.view.format.orderformat;

import christmas.view.input.MenuOrder;

public class OrderFormatter implements OrderFormat {
    private final OrderFormat orderFormat;

    public OrderFormatter(OrderFormat orderFormat) {
        this.orderFormat = orderFormat;
    }

    @Override
    public String format(MenuOrder menuOrder) {
        return orderFormat.format(menuOrder);
    }
}

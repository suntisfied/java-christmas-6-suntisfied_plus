package christmas.view.integration.orderformat;

import christmas.view.input.Order;

public class OrderFomatter implements OrderFormat {
    private final OrderFormat orderFormat;

    public OrderFomatter(OrderFormat orderFormat) {
        this.orderFormat = orderFormat;
    }

    @Override
    public String format(Order order) {
        return orderFormat.format(order);
    }
}

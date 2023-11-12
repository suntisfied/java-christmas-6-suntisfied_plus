package christmas.promotion.byorder;

import christmas.order.menu.Menu;
import christmas.view.input.Order;

public interface OrderGift {
    boolean check(Order order);

    Menu determineGift(Order order);
}

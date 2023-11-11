package christmas.promotion.bydate;

import christmas.promotion.Benefit;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;

public interface DateDiscount extends Benefit {
    boolean check(Date date, Order order);

    Discount calculateDiscount(Date date, Order order);
}

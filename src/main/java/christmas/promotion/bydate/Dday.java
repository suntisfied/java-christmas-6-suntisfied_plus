package christmas.promotion.bydate;

import christmas.order.TotalOrder;
import christmas.order.menu.Price;
import christmas.promotion.Defaults;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.function.Predicate;

public class Dday implements DateDiscount {
    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;

        TotalOrder totalOrder = new TotalOrder(order);
        Price totalOrderCost = totalOrder.calculateTotalOrderCost();

        if (isWithinDday.test(date) && isEnoughTotalOrder.test(totalOrderCost)) {
            validity = true;
        }
        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;

        if (check(date, order)) {
            int initialDiscount = Defaults.INITIAL_D_DAY_DISCOUNT.getNumber();
            int dDayDiscounts = date.date() - 1;
            totalDiscount = initialDiscount + (dDayDiscounts * 100);
        }

        return new Discount(totalDiscount);
    }

    Predicate<Date> isWithinDday = date -> date.date() <= 25;
}

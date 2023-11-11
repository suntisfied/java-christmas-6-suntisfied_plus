package christmas.promotion.bydate;

import christmas.order.OrderedTotal;
import christmas.order.menu.Price;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.List;
import java.util.function.Predicate;

public class Weekday implements DateDiscount {
    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;

        OrderedTotal orderedTotal = new OrderedTotal(order);
        Price totalOrderCost = orderedTotal.calculateTotalOrderCost();

        if (isWeekday.test(date) && isEnoughTotalOrder.test(totalOrderCost)) {
            validity = true;
        }

        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;
        if (check(date, order)) {
            totalDiscount = 2023;
        }
        return new Discount(totalDiscount);
    }

    Predicate<Date> isWeekday = date -> {
        List<Integer> weekdays = Days.WEEKDAYS.getDays();
        return weekdays.contains(date.date());
    };
}

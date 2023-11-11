package christmas.promotion.bydate;

import christmas.order.VolumeCalculator;
import christmas.order.OrderVolume;
import christmas.order.OrderedTotal;
import christmas.order.menu.Price;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.List;
import java.util.function.Predicate;

public class Weekday implements DateDiscount {
    OrderVolume dessertOrderVolume;

    public Weekday(Order order) {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        dessertOrderVolume =
                volumeCalculator.calculateOrderVolumeByCategory(order, "dessert");
    }

    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;

        OrderedTotal orderedTotal = new OrderedTotal(order);
        Price totalOrderCost = orderedTotal.calculateTotalOrderCost();

        if (isWeekday.test(date) && isDessertOrdered.test(order) && isEnoughTotalOrder.test(totalOrderCost)) {
            validity = true;
        }

        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;
        if (check(date, order)) {
            totalDiscount = 2023 * dessertOrderVolume.volume();
        }
        return new Discount(totalDiscount);
    }

    Predicate<Date> isWeekday = date -> {
        List<Integer> weekdays = Days.WEEKDAYS.getDays();
        return weekdays.contains(date.date());
    };

    Predicate<Order> isDessertOrdered = order -> dessertOrderVolume.volume() > 0;
}

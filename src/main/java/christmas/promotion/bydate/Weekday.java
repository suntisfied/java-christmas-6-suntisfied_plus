package christmas.promotion.bydate;

import static christmas.promotion.Defaults.WEEKDAY_DISCOUNT_UNIT;
import static christmas.promotion.bydate.Days.WEEKDAYS;

import christmas.order.TotalOrder;
import christmas.order.Volume;
import christmas.order.VolumeCalculator;
import christmas.order.menu.Category;
import christmas.order.menu.Price;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.List;
import java.util.function.Predicate;

public class Weekday implements DateDiscount {
    private Volume dessertVolume;

    public Weekday(Order order) {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        dessertVolume =
                volumeCalculator.calculateOrderVolumeByCategory(order, Category.DESSERT);
    }

    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;

        TotalOrder totalOrder = new TotalOrder(order);
        Price totalOrderCost = totalOrder.calculateTotalOrderCost();

        if (isWeekday.test(date) && isDessertOrdered.test(order) && isEnoughTotalOrder.test(totalOrderCost)) {
            validity = true;
        }

        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;
        if (check(date, order)) {
            totalDiscount = WEEKDAY_DISCOUNT_UNIT.getNumber() * dessertVolume.volume();
        }
        return new Discount(totalDiscount);
    }

    private final Predicate<Date> isWeekday = date -> {
        List<Integer> weekdays = WEEKDAYS.getDays();
        return weekdays.contains(date.date());
    };

    private final Predicate<Order> isDessertOrdered = order -> dessertVolume.volume() > 0;
}

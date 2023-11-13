package christmas.promotion.bydate;

import static christmas.promotion.Defaults.WEEKEND_DISCOUNT_UNIT;
import static christmas.promotion.bydate.Days.WEEKENDS;

import christmas.order.Volume;
import christmas.order.VolumeCalculator;
import christmas.order.menu.Category;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.List;
import java.util.function.Predicate;

public class Weekend implements DateDiscount {
    private Volume mainDishVolume;

    public Weekend(Order order) {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        mainDishVolume =
                volumeCalculator.calculateOrderVolumeByCategory(order, Category.MAIN_DISH);
    }

    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;
        if (isWeekend.test(date)
                && isMainOrdered.test(order)
                && isEnoughTotalOrder.test(order)) {
            validity = true;
        }
        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;
        if (check(date, order)) {
            totalDiscount = WEEKEND_DISCOUNT_UNIT.getNumber() * mainDishVolume.volume();
        }
        return new Discount(totalDiscount);
    }

    private final Predicate<Date> isWeekend = date -> {
        List<Integer> weekends = WEEKENDS.getDays();
        return weekends.contains(date.date());
    };

    private final Predicate<Order> isMainOrdered = order -> mainDishVolume.volume() > 0;
}

package christmas.promotion.bydate;

import christmas.order.VolumeCalculator;
import christmas.order.OrderVolume;
import christmas.order.TotalOrder;
import christmas.order.menu.Price;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.List;
import java.util.function.Predicate;

public class Weekend implements DateDiscount {
    OrderVolume mainDishOrderVolume;

    public Weekend(Order order) {
        VolumeCalculator volumeCalculator = new VolumeCalculator();
        mainDishOrderVolume =
                volumeCalculator.calculateOrderVolumeByCategory(order, "maindish");
    }

    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;

        TotalOrder totalOrder = new TotalOrder(order);
        Price totalOrderCost = totalOrder.calculateTotalOrderCost();

        if (isWeekend.test(date) && isMainOrdered.test(order) && isEnoughTotalOrder.test(totalOrderCost)) {
            validity = true;
        }
        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;
        if (check(date, order)) {
            totalDiscount = 2023 * mainDishOrderVolume.volume();
        }
        return new Discount(totalDiscount);
    }

    Predicate<Date> isWeekend = date -> {
        List<Integer> weekends = Days.WEEKENDS.getDays();
        return weekends.contains(date.date());
    };

    Predicate<Order> isMainOrdered = order -> mainDishOrderVolume.volume() > 0;

}

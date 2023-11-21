package christmas.promotion.datepromotion;

import static christmas.promotion.Defaults.WEEKDAY_DISCOUNT_UNIT;
import static christmas.promotion.datepromotion.Days.WEEKDAYS;

import christmas.order.TotalOrder;
import christmas.order.Volume;
import christmas.converter.Converter;
import christmas.order.menu.Category;
import christmas.promotion.Discount;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.util.List;
import java.util.function.Predicate;

public class Weekday extends DateDiscount {
    private Volume dessertVolume;

    public Weekday(MenuOrder menuOrder) {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(menuOrder);
        dessertVolume = totalOrder.calculateVolumeByCategory(Category.DESSERT);
    }

    @Override
    public Discount calculateDiscount(VisitDate visitDate, MenuOrder menuOrder) {
        int totalDiscount = 0;
        if (check(visitDate, menuOrder)) {
            totalDiscount = WEEKDAY_DISCOUNT_UNIT.getNumber() * dessertVolume.amount();
        }
        return new Discount(totalDiscount);
    }

    @Override
    protected boolean check(VisitDate visitDate, MenuOrder menuOrder) {
        return isWeekday.test(visitDate) && isDessertOrdered.test(menuOrder) && isEnoughTotalOrder.test(menuOrder);
    }

    private final Predicate<VisitDate> isWeekday = date -> {
        List<Integer> weekdays = WEEKDAYS.getDays();
        return weekdays.contains(date.number());
    };

    private final Predicate<MenuOrder> isDessertOrdered = order -> dessertVolume.amount() > 0;
}

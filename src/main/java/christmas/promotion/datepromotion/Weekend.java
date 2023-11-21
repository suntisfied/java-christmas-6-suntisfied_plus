package christmas.promotion.datepromotion;

import static christmas.promotion.Defaults.WEEKEND_DISCOUNT_UNIT;
import static christmas.promotion.datepromotion.Days.WEEKENDS;

import christmas.order.TotalOrder;
import christmas.order.Volume;
import christmas.converter.Converter;
import christmas.order.menu.Category;
import christmas.promotion.Discount;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.util.List;
import java.util.function.Predicate;

public class Weekend extends DateDiscount {
    private Volume mainDishVolume;

    public Weekend(MenuOrder menuOrder) {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(menuOrder);
        mainDishVolume = totalOrder.calculateVolumeByCategory(Category.MAIN_DISH);
    }

    @Override
    public Discount calculateDiscount(VisitDate visitDate, MenuOrder menuOrder) {
        int totalDiscount = 0;
        if (check(visitDate, menuOrder)) {
            totalDiscount = WEEKEND_DISCOUNT_UNIT.getNumber() * mainDishVolume.amount();
        }
        return new Discount(totalDiscount);
    }

    @Override
    public boolean check(VisitDate visitDate, MenuOrder menuOrder) {
        return isWeekend.test(visitDate) && isMainOrdered.test(menuOrder) && isEnoughTotalOrder.test(menuOrder);
    }

    private final Predicate<VisitDate> isWeekend = date -> {
        List<Integer> weekends = WEEKENDS.getDays();
        return weekends.contains(date.number());
    };

    private final Predicate<MenuOrder> isMainOrdered = order -> mainDishVolume.amount() > 0;
}

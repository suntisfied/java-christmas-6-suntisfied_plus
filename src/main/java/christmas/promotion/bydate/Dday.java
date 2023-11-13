package christmas.promotion.bydate;

import static christmas.promotion.Defaults.D_DAY;
import static christmas.promotion.Defaults.D_DAY_DISCOUNT_UNIT;
import static christmas.promotion.Defaults.INITIAL_D_DAY_DISCOUNT;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.function.Predicate;

public class Dday implements DateDiscount {
    @Override
    public boolean check(Date date, Order order) {
        boolean validity = false;
        if (isWithinDday.test(date) && isEnoughTotalOrder.test(order)) {
            validity = true;
        }
        return validity;
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        int totalDiscount = 0;

        if (check(date, order)) {
            int initialDiscount = INITIAL_D_DAY_DISCOUNT.getNumber();
            int dDayDiscounts = date.date() - 1;
            totalDiscount = initialDiscount + (dDayDiscounts * D_DAY_DISCOUNT_UNIT.getNumber());
        }

        return new Discount(totalDiscount);
    }

    private final Predicate<Date> isWithinDday = date -> date.date() <= D_DAY.getNumber();
}

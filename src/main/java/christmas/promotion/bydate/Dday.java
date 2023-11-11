package christmas.promotion.bydate;

import christmas.promotion.Defaults;
import christmas.promotion.Discount;
import christmas.view.input.Date;
import java.util.function.Predicate;

public class Dday implements DateDiscount {
    @Override
    public boolean check(Date date) {
        return isWithinDday.test(date);
    }

    @Override
    public Discount calculateDiscount(Date date) {
        int totalDiscount = 0;

        if (check(date)) {
            int initialDiscount = Defaults.INITIAL_D_DAY_DISCOUNT.getNumber();
            int dDayDiscounts = date.date() - 1;
            totalDiscount = initialDiscount + (dDayDiscounts * 100);
        }

        return new Discount(totalDiscount);
    }

    Predicate<Date> isWithinDday = date -> date.date() <= 25;
}

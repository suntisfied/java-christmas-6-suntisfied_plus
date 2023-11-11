package christmas.promotion.bydate;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import java.util.List;
import java.util.function.Predicate;

public class Special implements DateDiscount {
    @Override
    public boolean check(Date date) {
        return isSpecialDay.test(date);
    }

    @Override
    public Discount calculateDiscount(Date date) {
        int totalDiscount = 0;
        if (check(date)) {
            totalDiscount = 1000;
        }
        return new Discount(totalDiscount);
    }

    Predicate<Date> isSpecialDay = date -> {
        List<Integer> weekdays = Days.SPECIAL.getDays();
        return weekdays.contains(date.date());
    };
}

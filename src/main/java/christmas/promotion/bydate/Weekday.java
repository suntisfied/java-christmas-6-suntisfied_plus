package christmas.promotion.bydate;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import java.util.List;
import java.util.function.Predicate;

public class Weekday implements DateDiscount {
    @Override
    public boolean check(Date date) {
        return isWeekday.test(date);
    }

    @Override
    public Discount calculateDiscount(Date date) {
        return new Discount(2023);
    }

    Predicate<Date> isWeekday = date -> {
        List<Integer> weekdays = Days.WEEKDAYS.getDays();
        return weekdays.contains(date.date());
    };
}

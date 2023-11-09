package christmas.promotion.bydate;

import christmas.view.input.Date;
import java.util.function.Predicate;

public class Dday implements DateDiscount {
    @Override
    public boolean check(Date date) {
        return isWithinDday.test(date);
    }

    Predicate<Date> isWithinDday = date -> date.date() <= 25;
}

package christmas.promotion.datepromotion;

import static christmas.promotion.Defaults.SPECIAL_DISCOUNT;

import christmas.promotion.Discount;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.util.List;
import java.util.function.Predicate;

public class Special extends DateDiscount {
    @Override
    public Discount calculateDiscount(VisitDate visitDate, MenuOrder menuOrder) {
        int totalDiscount = 0;
        if (check(visitDate, menuOrder)) {
            totalDiscount = SPECIAL_DISCOUNT.getNumber();
        }
        return new Discount(totalDiscount);
    }

    @Override
    protected boolean check(VisitDate visitDate, MenuOrder menuOrder) {
        return isSpecialDay.test(visitDate) && isEnoughTotalOrder.test(menuOrder);
    }

    private final Predicate<VisitDate> isSpecialDay = date -> {
        List<Integer> weekdays = Days.SPECIAL.getDays();
        return weekdays.contains(date.number());
    };
}

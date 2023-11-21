package christmas.promotion.datepromotion;

import static christmas.promotion.Defaults.D_DAY;
import static christmas.promotion.Defaults.D_DAY_DISCOUNT_UNIT;
import static christmas.promotion.Defaults.INITIAL_D_DAY_DISCOUNT;

import christmas.promotion.Discount;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.util.function.Predicate;

public class Dday extends DateDiscount {
    @Override
    public Discount calculateDiscount(VisitDate visitDate, MenuOrder menuOrder) {
        int totalDiscount = 0;

        if (check(visitDate, menuOrder)) {
            int initialDiscount = INITIAL_D_DAY_DISCOUNT.getNumber();
            int dDayDiscounts = visitDate.number() - 1;
            totalDiscount = initialDiscount + (dDayDiscounts * D_DAY_DISCOUNT_UNIT.getNumber());
        }

        return new Discount(totalDiscount);
    }

    @Override
    protected boolean check(VisitDate visitDate, MenuOrder menuOrder) {
        return isWithinDday.test(visitDate) && isEnoughTotalOrder.test(menuOrder);
    }

    private final Predicate<VisitDate> isWithinDday = date -> date.number() <= D_DAY.getNumber();


}

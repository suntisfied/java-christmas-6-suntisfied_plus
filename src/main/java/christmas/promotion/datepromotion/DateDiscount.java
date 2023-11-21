package christmas.promotion.datepromotion;

import christmas.promotion.Benefit;
import christmas.promotion.Discount;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;

public abstract class DateDiscount extends Benefit {
    public abstract Discount calculateDiscount(VisitDate visitDate, MenuOrder menuOrder);

    protected abstract boolean check(VisitDate visitDate, MenuOrder menuOrder);
}

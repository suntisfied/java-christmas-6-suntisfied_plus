package christmas.promotion.datepromotion;

import christmas.promotion.Discount;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;

public class DateBenefit {
    private final DateDiscount dateDiscount;

    public DateBenefit(DateDiscount dateDiscount) {
        this.dateDiscount = dateDiscount;
    }
    
    public Discount calculateDiscount(VisitDate visitDate, MenuOrder menuOrder) {
        return dateDiscount.calculateDiscount(visitDate, menuOrder);
    }
}

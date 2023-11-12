package christmas.promotion.bydate;

import christmas.promotion.Discount;
import christmas.view.input.Date;
import christmas.view.input.Order;

public class DateBenefit implements DateDiscount {
    private final DateDiscount dateDiscount;

    public DateBenefit(DateDiscount dateDiscount) {
        this.dateDiscount = dateDiscount;
    }

    @Override
    public boolean check(Date date, Order order) {
        return dateDiscount.check(date, order);
    }

    @Override
    public Discount calculateDiscount(Date date, Order order) {
        return dateDiscount.calculateDiscount(date, order);
    }
}

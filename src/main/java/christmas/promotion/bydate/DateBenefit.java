package christmas.promotion.bydate;

import christmas.promotion.Discount;
import christmas.view.input.Date;

public class DateBenefit implements DateDiscount {
    private final DateDiscount dateDiscount;

    public DateBenefit() {
        this.dateDiscount = new Dday();
    }

    public DateBenefit(DateDiscount dateDiscount) {
        this.dateDiscount = dateDiscount;
    }

    @Override
    public boolean check(Date date) {
        return dateDiscount.check(date);
    }

    @Override
    public Discount calculateDiscount(Date date) {
        return dateDiscount.calculateDiscount(date);
    }
}

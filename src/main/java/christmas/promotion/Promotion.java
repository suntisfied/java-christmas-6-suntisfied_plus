package christmas.promotion;

import christmas.promotion.bydate.DateDiscount;
import christmas.view.input.Date;

public class Promotion implements DateDiscount{
    private final DateDiscount dateDiscount;

    public Promotion(DateDiscount dateDiscount) {
        this.dateDiscount = dateDiscount;
    }

    @Override
    public boolean check(Date date) {
        return dateDiscount.check(date);
    }
}

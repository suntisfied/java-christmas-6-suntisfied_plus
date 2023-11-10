package christmas.promotion.bydate;

import christmas.promotion.Discount;
import christmas.view.input.Date;

public interface DateDiscount {
    boolean checkDate(Date date);

    Discount calculateDiscount(Date date);
}

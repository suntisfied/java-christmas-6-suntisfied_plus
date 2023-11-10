package christmas.promotion;

import christmas.menu.Price;
import christmas.menu.MenuItems;
import christmas.promotion.bydate.DateDiscount;
import christmas.promotion.byorder.OrderDiscount;
import christmas.view.input.Date;

public class Promotion implements DateDiscount, OrderDiscount {
    private final DateDiscount dateDiscount;
    private final OrderDiscount orderDiscount;

    public Promotion(DateDiscount dateDiscount, OrderDiscount orderDiscount) {
        this.dateDiscount = dateDiscount;
        this.orderDiscount = orderDiscount;
    }

    @Override
    public boolean check(Date date) {
        return dateDiscount.check(date);
    }

    @Override
    public Discount calculateDiscount(Date date) {
        return dateDiscount.calculateDiscount(date);
    }

    @Override
    public boolean check(Price price) {
        return orderDiscount.check(price);
    }

    @Override
    public MenuItems calculateDiscount(Price price) {
        return orderDiscount.calculateDiscount(price);
    }
}

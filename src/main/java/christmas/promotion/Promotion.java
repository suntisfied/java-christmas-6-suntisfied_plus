package christmas.promotion;

import christmas.menu.Price;
import christmas.menu.MenuItems;
import christmas.promotion.bydate.DateDiscount;
import christmas.promotion.byorder.OrderGift;
import christmas.view.input.Date;

public class Promotion implements DateDiscount, OrderGift {
    private final DateDiscount dateDiscount;
    private final OrderGift orderGift;

    public Promotion(DateDiscount dateDiscount, OrderGift orderGift) {
        this.dateDiscount = dateDiscount;
        this.orderGift = orderGift;
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
        return orderGift.check(price);
    }

    @Override
    public MenuItems calculateDiscount(Price price) {
        return orderGift.calculateDiscount(price);
    }
}

package christmas.promotion;

import christmas.menu.Price;
import christmas.menu.MenuItems;
import christmas.promotion.bydate.DateDiscount;
import christmas.promotion.byorder.Badges;
import christmas.promotion.byorder.OrderBadge;
import christmas.promotion.byorder.OrderGift;
import christmas.view.input.Date;

public class Promotion implements DateDiscount, OrderGift, OrderBadge {
    private final DateDiscount dateDiscount;
    private final OrderGift orderGift;
    private final OrderBadge orderBadge;

    public Promotion(DateDiscount dateDiscount, OrderGift orderGift, OrderBadge orderBadge) {
        this.dateDiscount = dateDiscount;
        this.orderGift = orderGift;
        this.orderBadge = orderBadge;
    }

    @Override
    public boolean checkDate(Date date) {
        return dateDiscount.checkDate(date);
    }

    @Override
    public Discount calculateDiscount(Date date) {
        return dateDiscount.calculateDiscount(date);
    }

    @Override
    public boolean checkPrice(Price price) {
        return orderGift.checkPrice(price);
    }

    @Override
    public MenuItems determineGift(Price price) {
        return orderGift.determineGift(price);
    }

    @Override
    public boolean checkDiscount(Discount discount) {
        return orderBadge.checkDiscount(discount);
    }

    @Override
    public Badges determineBadge(Discount discount) {
        return null;
    }
}

package christmas.promotion.byorder;

import christmas.order.menu.Drinks;
import christmas.order.menu.Price;
import christmas.promotion.Discount;

public class OrderBenefit implements OrderGift, OrderBadge {
    private final OrderGift orderGift;
    private final OrderBadge orderBadge;

    public OrderBenefit() {
        this.orderGift = new FreeGift();
        this.orderBadge = new Badge();
    }

    public OrderBenefit(OrderGift orderGift, OrderBadge orderBadge) {
        this.orderGift = orderGift;
        this.orderBadge = orderBadge;
    }

    @Override
    public boolean checkPrice(Price price) {
        return orderGift.checkPrice(price);
    }

    @Override
    public Drinks determineGift(Price price) {
        return orderGift.determineGift(price);
    }

    @Override
    public boolean checkDiscount(Discount discount) {
        return orderBadge.checkDiscount(discount);
    }

    @Override
    public Badges determineBadge(Discount discount) {
        return orderBadge.determineBadge(discount);
    }
}

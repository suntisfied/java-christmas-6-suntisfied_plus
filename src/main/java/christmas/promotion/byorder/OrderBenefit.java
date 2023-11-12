package christmas.promotion.byorder;

import christmas.promotion.Discount;
import christmas.view.input.Order;

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
    public boolean check(Order order) {
        return orderGift.check(order);
    }

    @Override
    public FreeGifts determineGift(Order order) {
        return orderGift.determineGift(order);
    }

    @Override
    public boolean check(Discount discount) {
        return orderBadge.check(discount);
    }

    @Override
    public Badges determineBadge(Discount discount) {
        return orderBadge.determineBadge(discount);
    }
}

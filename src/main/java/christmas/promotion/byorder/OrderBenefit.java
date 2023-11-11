package christmas.promotion.byorder;

import christmas.order.menu.Menu;
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
    public boolean check(Price price) {
        return orderGift.check(price);
    }

    @Override
    public Menu determineGift(Price price) {
        return orderGift.determineGift(price);
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

package christmas.promotion.byorder;

import christmas.order.Volume;
import christmas.promotion.Discount;
import christmas.view.input.Order;
import java.util.Map;

public class OrderBenefit {
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

    public Map<FreeGifts, Volume> determineGift(Order order) {
        return orderGift.determineGift(order);
    }

    public Badges determineBadge(Discount discount) {
        return orderBadge.determineBadge(discount);
    }
}

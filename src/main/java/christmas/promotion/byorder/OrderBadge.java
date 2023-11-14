package christmas.promotion.byorder;

import christmas.promotion.Benefit;
import christmas.promotion.Discount;

public abstract class OrderBadge extends Benefit {
    public  abstract Badges determineBadge(Discount discount);

    protected abstract boolean check(Discount discount);
}

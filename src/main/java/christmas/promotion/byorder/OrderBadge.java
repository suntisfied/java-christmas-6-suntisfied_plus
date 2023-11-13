package christmas.promotion.byorder;

import christmas.promotion.Benefit;
import christmas.promotion.Discount;

public interface OrderBadge extends Benefit {
    boolean check(Discount discount);

    Badges determineBadge(Discount discount);
}

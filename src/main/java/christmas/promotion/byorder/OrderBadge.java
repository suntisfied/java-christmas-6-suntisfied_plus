package christmas.promotion.byorder;

import christmas.promotion.Discount;

public interface OrderBadge {
    boolean check(Discount discount);

    Badges determineBadge(Discount discount);
}

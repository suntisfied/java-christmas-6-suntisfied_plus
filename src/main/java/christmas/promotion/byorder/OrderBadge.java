package christmas.promotion.byorder;

import christmas.promotion.Discount;

public interface OrderBadge {
    boolean checkDiscount(Discount discount);

    Badges determineBadge(Discount discount);
}

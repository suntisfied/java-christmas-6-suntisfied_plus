package christmas.promotion.byorder;

import christmas.promotion.Discount;
import java.util.function.Predicate;

public class Badge implements OrderBadge {
    @Override
    public boolean checkDiscount(Discount discount) {
        return isEnough.test(discount);
    }

    @Override
    public Badges determineBadge(Discount discount) {
        Badges badge = Badges.NONE;
        if (discount.amount() < 10000) {
            badge = Badges.STAR;
        }
        if (discount.amount() >= 10000 && discount.amount() < 20000) {
            badge = Badges.TREE;
        }
        if (discount.amount() >= 20000) {
            badge = Badges.SANTA;
        }
        return badge;
    }

    Predicate<Discount> isEnough = discount -> discount.amount() >= 5000;
}

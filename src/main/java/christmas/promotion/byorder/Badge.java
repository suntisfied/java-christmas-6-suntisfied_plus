package christmas.promotion.byorder;

import christmas.menu.Price;
import christmas.promotion.Discount;
import java.util.function.Predicate;

public class Badge implements OrderBadge {
    @Override
    public boolean checkDiscount(Discount discount) {
        return isEnough.test(discount);
    }

    @Override
    public Badges determineBadge(Discount discount) {
        return null;
    }

    Predicate<Discount> isEnough = discount -> discount.amount() >= 5000;
}

package christmas.promotion.byorder;

import static christmas.promotion.byorder.Badges.NONE;
import static christmas.promotion.byorder.Badges.SANTA;
import static christmas.promotion.byorder.Badges.STAR;
import static christmas.promotion.byorder.Badges.TREE;

import christmas.promotion.Benefit;
import christmas.promotion.Discount;
import java.util.function.Predicate;

public class Badge extends Benefit {
    public Badges determineBadge(Discount discount) {
        Badges badge = NONE;
        if (check(discount)) {
            if (discount.amount() < TREE.getRequiredOrder()) {
                badge = STAR;
            }
            if (discount.amount() >= TREE.getRequiredOrder() && discount.amount() < SANTA.getRequiredOrder()) {
                badge = TREE;
            }
            if (discount.amount() >= SANTA.getRequiredOrder()) {
                badge = SANTA;
            }
        }
        return badge;
    }

    protected boolean check(Discount discount) {
        return isEnough.test(discount);
    }

    private final Predicate<Discount> isEnough = discount -> discount.amount() >= STAR.getRequiredOrder();
}

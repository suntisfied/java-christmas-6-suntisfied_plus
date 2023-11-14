package christmas.promotion;

import static christmas.promotion.Badges.NONE;
import static christmas.promotion.Badges.SANTA;
import static christmas.promotion.Badges.STAR;
import static christmas.promotion.Badges.TREE;

import christmas.converter.Converter;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.util.function.Predicate;

public class Badge extends Benefit {
    public Badges determineBadge(Date date, Order order) {
        Discount discount = calculateTotalDiscount(date, order);

        Badges badge = NONE;
        if (check(date, order)) {
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

    protected boolean check(Date date, Order order) {
        Discount discount = calculateTotalDiscount(date, order);
        return isEnough.test(discount);
    }

    private final Predicate<Discount> isEnough = discount -> discount.amount() >= STAR.getRequiredOrder();

    private Discount calculateTotalDiscount(Date date, Order order) {
        TotalBenefit totalBenefit = new Converter().convertToTotalBenefit(date, order);
        return totalBenefit.calculateTotalBenefit();
    }
}

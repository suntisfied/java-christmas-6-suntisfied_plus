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

        if (check(date, order)) {
            if (discount.amount() >= SANTA.getRequiredOrder()) {
                return SANTA;
            }
            if (discount.amount() >= TREE.getRequiredOrder()) {
                return TREE;
            }
            if (discount.amount() >= STAR.getRequiredOrder()) {
                return STAR;
            }
        }
        return NONE;
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

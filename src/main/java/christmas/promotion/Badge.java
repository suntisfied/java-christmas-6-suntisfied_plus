package christmas.promotion;

import static christmas.promotion.Badges.NONE;
import static christmas.promotion.Badges.SANTA;
import static christmas.promotion.Badges.STAR;
import static christmas.promotion.Badges.TREE;

import christmas.converter.Converter;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;

public class Badge extends Benefit {
    public Badges determineBadge(VisitDate visitDate, MenuOrder menuOrder) {
        Discount discount = calculateTotalDiscount(visitDate, menuOrder);

        if (discount.amount() >= SANTA.getRequiredOrder()) {
            return SANTA;
        }
        if (discount.amount() >= TREE.getRequiredOrder()) {
            return TREE;
        }
        if (discount.amount() >= STAR.getRequiredOrder()) {
            return STAR;
        }
        return NONE;
    }

    private Discount calculateTotalDiscount(VisitDate visitDate, MenuOrder menuOrder) {
        TotalBenefit totalBenefit = new Converter().convertToTotalBenefit(visitDate, menuOrder);
        return totalBenefit.calculateTotalBenefit();
    }
}

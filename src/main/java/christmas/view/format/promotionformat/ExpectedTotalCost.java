package christmas.view.format.promotionformat;

import christmas.order.TotalOrder;
import christmas.converter.Converter;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.text.NumberFormat;
import java.util.Locale;

public class ExpectedTotalCost implements PromotionFormat {
    private final NumberFormat numberFormatter;

    public ExpectedTotalCost() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(VisitDate visitDate, MenuOrder menuOrder) {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(menuOrder);
        TotalBenefit totalBenefit = new Converter().convertToTotalBenefit(visitDate, menuOrder);

        int totalOrderCost = totalOrder.calculateTotalCost().amount();
        int totalBenefitAmount = totalBenefit.calculateTotalBenefit().amount();
        int freeGiftBenefit = totalBenefit.getDiscountByPromotion(Promotions.FREE_GIFT).amount();

        int expectedTotalCost = totalOrderCost - totalBenefitAmount + freeGiftBenefit;

        return numberFormatter.format(expectedTotalCost)
                + Messages.UNIT_CURRENCY.getMessage();
    }
}

package christmas.view.integration.promotionformat;

import christmas.order.TotalOrder;
import christmas.order.converter.Converter;
import christmas.promotion.Discount;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class ExpectedTotalCost implements PromotionFormat {
    private final NumberFormat numberFormatter;

    public ExpectedTotalCost() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(Date date, Order order) {
        TotalOrder totalOrder = new Converter().createTotalOrder(order);
        TotalBenefit totalBenefit = new TotalBenefit();

        Map<Promotions, Discount> benefits = totalBenefit.createBenefits(date, order);

        int totalOrderCost = totalOrder.calculateTotalCost().price();
        int totalBenefitAmount = totalBenefit.calculateTotalBenefit(date, order).amount();
        int freeGiftBenefit = benefits.get(Promotions.FREE_GIFT).amount();

        int expectedTotalCost = totalOrderCost - totalBenefitAmount + freeGiftBenefit;

        return numberFormatter.format(expectedTotalCost)
                + Messages.UNIT_CURRENCY.getMessage();
    }
}

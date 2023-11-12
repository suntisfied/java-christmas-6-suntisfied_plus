package christmas.view.integration.promotionformat;

import christmas.order.TotalOrder;
import christmas.promotion.Discount;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class ExpectedTotalCost implements PromotionFormat {
    NumberFormat numberFormatter;

    public ExpectedTotalCost() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    @Override
    public String format(Date date, Order order) {
        TotalOrder totalOrder = new TotalOrder(order);
        TotalBenefit totalBenefit = new TotalBenefit();

        HashMap<Promotions, Discount> benefits = totalBenefit.createBenefits(date, order);

        int totalOrderCost = totalOrder.calculateTotalOrderCost().price();
        int totalBenefitAmount = totalBenefit.calculateTotalBenefit(date, order).amount();
        int freeGiftBenefit = benefits.get(Promotions.FREE_GIFT).amount();

        int expectedTotalCost = totalOrderCost - totalBenefitAmount + freeGiftBenefit;

        return numberFormatter.format(expectedTotalCost)
                + Messages.UNIT_CURRENCY.getMessage();
    }
}

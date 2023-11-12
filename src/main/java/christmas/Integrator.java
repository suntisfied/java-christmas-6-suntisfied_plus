package christmas;

import christmas.order.OrderVolume;
import christmas.order.TotalOrder;
import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.promotion.Discount;
import christmas.promotion.Promotions;
import christmas.promotion.TotalBenefit;
import christmas.promotion.byorder.OrderBenefit;
import christmas.view.Messages;
import christmas.view.input.Date;
import christmas.view.input.Order;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Integrator {
    NumberFormat numberFormatter;

    public Integrator() {
        numberFormatter = NumberFormat.getInstance(Locale.US);
    }

    protected String formatOrderedMenu(Order order) {
        Converter converter = new Converter();
        HashMap<Menu, OrderVolume> orderedMenu = converter.createOrderedMenuTotal(order).orderedMenuTotal();
        List<Menu> orderedMenuNames = converter.createOrderedMenuNameList(order);

        StringBuilder stringBuilder = new StringBuilder();
        for (Menu menu : orderedMenuNames) {
            stringBuilder.append(menu.getName())
                    .append(" ")
                    .append(orderedMenu.get(menu).volume())
                    .append(Messages.UNIT_COUNT.getMessage())
                    .append("\r\n");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        return stringBuilder.toString();
    }

    protected String formatTotalCostBeforePromotion(Order order) {
        TotalOrder totalOrder = new TotalOrder(order);
        int totalOrderCost = totalOrder.calculateTotalOrderCost().price();

        return numberFormatter.format(totalOrderCost)
                + Messages.UNIT_CURRENCY.getMessage();
    }

    protected String formatFreeGift(Order order) {
        OrderBenefit orderBenefit = new OrderBenefit();

        String freeGiftText = Promotions.NONE.getText();

        if (!orderBenefit.determineGift(order).freeGifts().isEmpty()) {
            HashMap<Menu, OrderVolume> rawFreeGifts = orderBenefit.determineGift(order).freeGifts();
            Set<Menu> freeGiftNames = rawFreeGifts.keySet();
            StringBuilder stringBuilder = new StringBuilder();
            for (Menu menu : freeGiftNames) {
                stringBuilder.append(menu.getName())
                        .append(" ")
                        .append(rawFreeGifts.get(menu).volume())
                        .append(Messages.UNIT_COUNT.getMessage());
            }
            freeGiftText = stringBuilder.toString();
        }

        return freeGiftText;
    }

    protected String formatPromotionList(Date date, Order order) {
        StringBuilder stringBuilder = new StringBuilder();

        TotalBenefit totalBenefit = new TotalBenefit();
        HashMap<Promotions, Discount> benefits = totalBenefit.createBenefits(date, order);

        if (benefits.get(Promotions.D_DAY).amount() > 0) {
            stringBuilder.append(Promotions.D_DAY.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.D_DAY).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
            stringBuilder.append("\r\n");
        }

        if (benefits.get(Promotions.WEEKDAY).amount() > 0) {
            stringBuilder.append(Promotions.WEEKDAY.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.WEEKDAY).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
            stringBuilder.append("\r\n");
        }

        if (benefits.get(Promotions.WEEKEND).amount() > 0) {
            stringBuilder.append(Promotions.WEEKEND.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.WEEKEND).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
            stringBuilder.append("\r\n");
        }

        if (benefits.get(Promotions.SPECIAL).amount() > 0) {
            stringBuilder.append(Promotions.SPECIAL.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.SPECIAL).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
            stringBuilder.append("\r\n");
        }

        if (benefits.get(Promotions.FREE_GIFT).amount() > 0) {
            stringBuilder.append(Promotions.FREE_GIFT.getText());
            stringBuilder.append(Messages.MINUS.getMessage());
            stringBuilder.append(numberFormatter.format(benefits.get(Promotions.FREE_GIFT).amount()));
            stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());
        }

        if (stringBuilder.isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(Promotions.NONE.getText());
        }

        return stringBuilder.toString();
    }

    protected String formatTotalBenefitAmount(Date date, Order order) {
        TotalBenefit totalBenefit = new TotalBenefit();
        int totalBenefitAmount = totalBenefit.calculateTotalBenefit(date, order).amount();

        StringBuilder stringBuilder = new StringBuilder();
        if (totalBenefitAmount > 0) {
            stringBuilder.append(Messages.MINUS.getMessage());
        }
        stringBuilder.append(numberFormatter.format(totalBenefitAmount));
        stringBuilder.append(Messages.UNIT_CURRENCY.getMessage());

        return stringBuilder.toString();
    }

    protected String formatExpectedTotalCostAfterPromotion(Date date, Order order) {
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

    protected String formatBadge(Date date, Order order) {
        OrderBenefit orderBenefit = new OrderBenefit();
        TotalBenefit totalBenefit = new TotalBenefit();

        Discount totalBenefitAmount = totalBenefit.calculateTotalBenefit(date, order);

        return orderBenefit.determineBadge(totalBenefitAmount).getName();
    }
}

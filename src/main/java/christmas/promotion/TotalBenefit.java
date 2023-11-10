package christmas.promotion;

import christmas.menu.Price;
import christmas.promotion.bydate.DateBenefit;
import christmas.promotion.byorder.OrderBenefit;
import christmas.view.input.Date;

public class TotalBenefit {
    public Discount calculateTotalBenefit(Date date, Price price) {
        DateBenefit dateBenefit = new DateBenefit();
        OrderBenefit orderBenefit = new OrderBenefit();

        int totalBenefit =
                dateBenefit.calculateTotalDateBenefit(date).amount() +
                        orderBenefit.calculateTotalOrderBenefit(price).amount();

        return new Discount(totalBenefit);
    }
}

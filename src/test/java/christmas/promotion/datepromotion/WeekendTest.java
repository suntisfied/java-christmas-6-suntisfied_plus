package christmas.promotion.datepromotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Discount;
import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WeekendTest {
    @ParameterizedTest
    @CsvSource({
            "'티본스테이크-1,레드와인-1', 8, 2023",
            "'티본스테이크-2,레드와인-1', 8, 4046",
            "'타파스-2,레드와인-1', 8, 0",
            "'티본스테이크-2,레드와인-1', 7, 0",
    })
    public void calculateWeekendDiscount(String orderList, int date, int discount) {
        MenuOrder menuOrder = new MenuOrder(orderList);
        DateBenefit dateBenefit = new DateBenefit(new Weekend(menuOrder));

        assertThat(dateBenefit.calculateDiscount(new VisitDate(date), menuOrder)).isEqualTo(new Discount(discount));
    }
}
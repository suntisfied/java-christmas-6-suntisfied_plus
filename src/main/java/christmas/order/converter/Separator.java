package christmas.order.converter;

import christmas.view.input.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    List<String> createMenuNameAndAmounts(Order order) {
        List<String> menuNameAndAmountsWithDash = splitInputsByComma(order.order());
        List<String> menuNameAndAmounts = new ArrayList<>();

        for (String menuNameAndAmountWithDash : menuNameAndAmountsWithDash) {
            List<String> currentMenuNameAndAmounts = splitInputsByDash(menuNameAndAmountWithDash);
            menuNameAndAmounts.addAll(currentMenuNameAndAmounts);
        }

        return menuNameAndAmounts;
    }

    private List<String> splitInputsByDash(String rawOrder) {
        return Arrays.asList(rawOrder.split("-"));
    }

    private List<String> splitInputsByComma(String rawOrder) {
        return Arrays.asList(rawOrder.split(","));
    }
}

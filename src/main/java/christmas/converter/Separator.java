package christmas.converter;

import static christmas.converter.Delimiters.DELIMITER_NAME_WITH_VOLUME;
import static christmas.converter.Delimiters.DELIMITER_ORDER;

import christmas.view.input.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    public List<String> createMenuNameAndVolumes(Order order) {
        List<String> menuNameAndAmountsWithDash = splitInputsByComma(order.orderText());
        List<String> menuNameAndAmounts = new ArrayList<>();

        for (String menuNameAndAmountWithDash : menuNameAndAmountsWithDash) {
            List<String> currentMenuNameAndAmounts = splitInputsByDash(menuNameAndAmountWithDash);
            menuNameAndAmounts.addAll(currentMenuNameAndAmounts);
        }

        return menuNameAndAmounts;
    }

    private List<String> splitInputsByDash(String rawOrder) {
        return Arrays.asList(rawOrder.split(DELIMITER_NAME_WITH_VOLUME.getDelimiter()));
    }

    private List<String> splitInputsByComma(String rawOrder) {
        return Arrays.asList(rawOrder.split(DELIMITER_ORDER.getDelimiter()));
    }
}

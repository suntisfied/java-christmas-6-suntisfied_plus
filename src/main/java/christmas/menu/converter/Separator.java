package christmas.menu.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    List<String> createMenuNameAndAmounts(String inputs) {
        List<String> menuNameAndAmountsWithDash = splitInputsByComma(inputs);
        List<String> menuNameAndAmounts = new ArrayList<>();

        for (String menuNameAndAmountWithDash : menuNameAndAmountsWithDash) {
            List<String> currentMenuNameAndAmounts = splitInputsByDash(menuNameAndAmountWithDash);
            menuNameAndAmounts.addAll(currentMenuNameAndAmounts);
        }

        return menuNameAndAmounts;
    }

    private List<String> splitInputsByDash(String inputs) {
        return Arrays.asList(inputs.split("-"));
    }

    private List<String> splitInputsByComma(String inputs) {
        return Arrays.asList(inputs.split(","));
    }
}

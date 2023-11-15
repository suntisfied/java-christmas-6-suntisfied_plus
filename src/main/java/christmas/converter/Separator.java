package christmas.converter;

import static christmas.converter.Delimiters.DELIMITER_NAME_WITH_VOLUME;
import static christmas.converter.Delimiters.DELIMITER_ORDER;

import christmas.view.input.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    public List<String> createMenuNameAndVolumes(Order order) {
        List<String> menuNameWithVolumes = splitToNameWithVolume(order.orderText());

        List<String> menuNameAndVolumes = new ArrayList<>();
        for (String currentMenuNameWithVolume : menuNameWithVolumes) {
            List<String> currentMenuNameAndVolume = splitToNameAndVolume(currentMenuNameWithVolume);
            menuNameAndVolumes.addAll(currentMenuNameAndVolume);
        }

        return menuNameAndVolumes;
    }

    private List<String> splitToNameAndVolume(String menuNameWithVolume) {
        return Arrays.asList(menuNameWithVolume.split(DELIMITER_NAME_WITH_VOLUME.getDelimiter()));
    }

    private List<String> splitToNameWithVolume(String orderText) {
        return Arrays.asList(orderText.split(DELIMITER_ORDER.getDelimiter()));
    }
}

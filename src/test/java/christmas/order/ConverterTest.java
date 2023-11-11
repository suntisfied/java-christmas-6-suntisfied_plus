package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.view.input.Order;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class ConverterTest {
    Order order = new Order("해산물파스타-2,레드와인-1,초코케이크-1");
    Converter converter = new Converter();

    @Test
    public void convertInputToMenuList() {
        HashMap<String, Integer>extractedNameAndAmounts = converter.createExtractedNameAndAmounts(order);

        assertThat(extractedNameAndAmounts.get("해산물파스타")).isEqualTo(2);
        assertThat(extractedNameAndAmounts.get("레드와인")).isEqualTo(1);
        assertThat(extractedNameAndAmounts.get("초코케이크")).isEqualTo(1);
    }

    @Test
    public void convertInputToMenus() {
        OrderWithVolume orderWithVolumeMenus = converter.createOrderedMenuTotal(order);
        HashMap<Menu, OrderVolume> rawOrderedMenus = orderWithVolumeMenus.orderedMenuTotal();

        assertThat(rawOrderedMenus.get(Menu.SEAFOOD_PASTA)).isEqualTo(new OrderVolume(2));
        assertThat(rawOrderedMenus.get(Menu.RED_WINE)).isEqualTo(new OrderVolume(1));
        assertThat(rawOrderedMenus.get(Menu.CHOCOLATE_CAKE)).isEqualTo(new OrderVolume(1));
    }
}
package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.converter.Converter;
import christmas.order.menu.Menu;
import christmas.view.input.Order;
import org.junit.jupiter.api.Test;

class ConverterTest {
    Order order = new Order("해산물파스타-2,레드와인-1,초코케이크-1");

    @Test
    public void convertInputToMenuList() {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(order);

        assertThat(totalOrder.getVolumeByMenu(Menu.convertNameToMenu("해산물파스타"))).isEqualTo(new Volume(2));
        assertThat(totalOrder.getVolumeByMenu(Menu.convertNameToMenu("레드와인"))).isEqualTo(new Volume(1));
        assertThat(totalOrder.getVolumeByMenu(Menu.convertNameToMenu("초코케이크"))).isEqualTo(new Volume(1));
    }

    @Test
    public void convertInputToMenus() {
        TotalOrder totalOrder = new Converter().convertToTotalOrder(order);

        assertThat(totalOrder.getVolumeByMenu(Menu.SEAFOOD_PASTA)).isEqualTo(new Volume(2));
        assertThat(totalOrder.getVolumeByMenu(Menu.RED_WINE)).isEqualTo(new Volume(1));
        assertThat(totalOrder.getVolumeByMenu(Menu.CHOCOLATE_CAKE)).isEqualTo(new Volume(1));
    }
}
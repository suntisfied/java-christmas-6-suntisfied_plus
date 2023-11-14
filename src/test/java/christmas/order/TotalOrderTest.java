package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.converter.Converter;
import christmas.order.menu.Menu;
import christmas.order.menu.Price;
import christmas.view.input.Order;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TotalOrderTest {
    Order order = new Order("티본스테이크-2,양송이수프-1,아이스크림-1,레드와인-2");
    TotalOrder totalOrder = new Converter().convertToTotalOrder(order);

    @Test
    public void produceOrderedItemList() {
        assertThat(totalOrder.produceOrderedMenus())
                .containsExactlyInAnyOrderElementsOf(Arrays.asList(
                        Menu.T_BONE_STEAK,
                        Menu.MUSHROOM_CREAM_SOUP,
                        Menu.ICE_CREAM,
                        Menu.RED_WINE));
    }

    @Test
    public void calculateTotalOrderCost() {
        assertThat(totalOrder.calculateTotalCost()).isEqualTo(new Price(241000));
    }
}
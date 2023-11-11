package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import christmas.order.menu.Menu;
import christmas.order.menu.Price;
import christmas.view.input.Order;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class TotalOrderTest {
    Order order = new Order("티본스테이크-2,양송이수프-1,아이스크림-1,레드와인-2");
    TotalOrder totalOrder = new TotalOrder(order);

    @Test
    public void produceOrderedItemList() {
        assertThat(totalOrder.produceOrderedMenu().orderedMenus())
                .containsExactlyInAnyOrderElementsOf(new OrderedMenus(Arrays.asList(
                        Menu.T_BONE_STEAK,
                        Menu.MUSHROOM_CREAM_SOUP,
                        Menu.ICE_CREAM,
                        Menu.RED_WINE)).orderedMenus());
    }

    @Test
    public void calculateTotalOrderCost() {
        assertThat(totalOrder.calculateTotalOrderCost()).isEqualTo(new Price(241000));
    }

    @Test
    public void checkOrderVolume() {
        Order order = new Order("티본스테이크-2,양송이수프-10,아이스크림-7,레드와인-2");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TotalOrder(order));
    }

    @Test
    public void checkOnlyDrinkOrder() {
        Order order = new Order("레드와인-2");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TotalOrder(order));
    }
}
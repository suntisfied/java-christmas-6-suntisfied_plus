package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import christmas.order.menu.Appetizers;
import christmas.order.menu.Desserts;
import christmas.order.menu.Drinks;
import christmas.order.menu.MainDishes;
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
                        MainDishes.T_BONE_STEAK,
                        Appetizers.MUSHROOM_CREAM_SOUP,
                        Desserts.ICE_CREAM,
                        Drinks.RED_WINE)).orderedMenus());
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
}
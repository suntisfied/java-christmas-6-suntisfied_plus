package christmas.order;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.order.menu.Appetizers;
import christmas.order.menu.Desserts;
import christmas.order.menu.Drinks;
import christmas.order.menu.MainDishes;
import christmas.view.input.Order;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class OrderedTotalTest {
    Order order = new Order("티본스테이크-2,양송이수프-1,아이스크림-1,레드와인-2");
    OrderedTotal orderedTotal = new OrderedTotal(order);

    @Test
    public void produceOrderedItemList() {
        assertThat(orderedTotal.produceOrderedMenu().orderedMenus())
                .containsExactlyInAnyOrderElementsOf(new OrderedMenus(Arrays.asList(
                        MainDishes.T_BONE_STEAK,
                        Appetizers.MUSHROOM_CREAM_SOUP,
                        Desserts.ICE_CREAM,
                        Drinks.RED_WINE)).orderedMenus());
    }

    @Test
    public void calculateTotalOrderCost() {
        assertThat(orderedTotal.calculateTotalOrderAmount()).isEqualTo(new OrderAmount(241000));
    }
}
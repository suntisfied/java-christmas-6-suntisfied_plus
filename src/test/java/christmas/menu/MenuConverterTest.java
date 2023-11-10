package christmas.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MenuConverterTest {
    @Test
    public void convertInputToMenu() {
        MenuConverter menuConverter = new MenuConverter();

        assertThat(menuConverter.convertInputToMenu("티본스테이크")).isEqualTo(MainDishes.T_BONE_STEAK);
    }
}
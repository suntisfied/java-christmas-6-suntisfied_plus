package christmas.promotion.bydate;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.promotion.Promotion;
import christmas.view.input.Date;
import org.junit.jupiter.api.Test;

class DdayTest {
    Promotion promotion = new Promotion(new Dday());

    @Test
    public void checkWithinDday() {
        assertThat(promotion.check(new Date(7))).isTrue();
    }

    @Test
    public void checkBeyondDday() {
        assertThat(promotion.check(new Date(26))).isFalse();
    }
}
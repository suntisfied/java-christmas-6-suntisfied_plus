package christmas.view.input;

public enum Messages {
    INTRODUCTION("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    DATE_INPUT_INSTRUCTION("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER_INPUT_INSTRUCTION("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    HEAD_PREVIEW("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    HEAD_ORDER_LIST("<주문 메뉴>"),
    HEAD_ORDER_AMOUNT("<할인 전 총주문 금액>"),
    HEAD_FREE_GIFT("<증정 메뉴>"),
    HEAD_PROMOTION_LIST("<혜택 내역>"),
    HEAD_PROMOTION_AMOUNT("<총혜택 금액>"),
    HEAD_EXPECT_TOTAL_COST("<할인 후 예상 결제 금액>"),
    HEAD_BADGE("<12월 이벤트 배지>"),
    ERROR_NOT_POSITIVE_INTEGER("[ERROR] 양의 정수를 입력해주세요."),
    ERROR_NOT_VALID_DATE("[ERROR] 1에서 31까지의 수를 입력해주세요."),
    ERROR_OVER_ORDER_AMOUNT_LIMIT("[ERROR] 주문은 20개까지 할 수 있습니다."),
    ERROR_ONLY_DRINK_ORDER("[ERROR] 음료만 주문할 수 없습니다."),
    ERROR_INVALID_FORMAT("[ERROR] 올바른 주문 형식이 아닙니다.\n메뉴와 갯수는 대시(-)와 쉼표(,)로 구분해주세요.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

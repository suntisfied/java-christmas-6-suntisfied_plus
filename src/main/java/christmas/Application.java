package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.input.VisitDate;
import christmas.view.input.DateInputReader;
import christmas.view.input.MenuOrder;
import christmas.view.input.OrderInputReader;
import christmas.view.output.Preview;

public class Application {
    public static void main(String[] args) {
        DateInputReader dateInputReader = new DateInputReader();
        OrderInputReader orderInputReader = new OrderInputReader();
        Preview preview = new Preview();

        VisitDate visitDate = dateInputReader.askDate();
        MenuOrder menuOrder = orderInputReader.askOrder();

        preview.display(visitDate, menuOrder);

        Console.close();
    }
}

package christmas.view.output;

import static christmas.view.Messages.HEAD_PREVIEW;

import christmas.view.input.VisitDate;
import christmas.view.input.MenuOrder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Preview {
    public void display(VisitDate visitDate, MenuOrder menuOrder) {
        System.out.println(buildPreview(visitDate, menuOrder));
    }

    public String buildPreview(VisitDate visitDate, MenuOrder menuOrder) {
        Map<String, String> previews = new LinkedHashMap<>(new OrderPreview().build(menuOrder));
        previews.putAll(new PromotionPreview().build(visitDate, menuOrder));

        String previewText = previews.entrySet().stream()
                .flatMap(entry -> Stream.of(entry.getKey() + System.lineSeparator(),
                        entry.getValue() + System.lineSeparator() + System.lineSeparator()))
                .collect(Collectors.joining());

        return HEAD_PREVIEW.getMessage()
                + System.lineSeparator()
                + System.lineSeparator()
                + previewText;
    }
}

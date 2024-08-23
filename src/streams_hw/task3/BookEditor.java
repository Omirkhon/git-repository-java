package streams_hw.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookEditor {

    HeaderDecorator headerDecorator = string -> string.toUpperCase() + "\n";
    LineProcessor lineProcessor = string -> string.substring(0, 1).toUpperCase() + string.substring(1);

    public static void main(String[] args) {
        BookEditor bookEditor = new BookEditor();

        List<String> content = Arrays.asList(
                "Приключения Java-программиста",
                "История началась рано утром, ",
                "когда программист вышел из дома, ",
                "решив выпить утренний кофе."
        );

        List<String> resultContent = bookEditor.processText(content);
        System.out.println(resultContent);
    }

    public List<String> processText(List<String> sourceText) {
        List<String> resultText = new ArrayList<>();

        String sourceHeader = sourceText.get(0);
        String decoratedHeader = headerDecorator.decorate(sourceHeader);
        resultText.add(decoratedHeader);

        for (int i = 1; i < sourceText.size(); i++) {
            String currentLine = sourceText.get(i);
            currentLine = lineProcessor.processLine(currentLine);
            resultText.add(currentLine);
        }

        return resultText;
    }
}
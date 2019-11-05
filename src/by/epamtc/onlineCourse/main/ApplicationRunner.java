package by.epamtc.onlineCourse.main;

import by.epamtc.onlineCourse.view.RegExView;
import by.epamtc.onlineCourse.view.TextView;

public class ApplicationRunner {

    public static void main(String[] args) {

        String inputString="Создать приложение. Разбирающее текст, текст хранится в строке. Позволяющее " +
                "выполнять с текстом три различных операции." +
                "\n\tОтсортировать абзацы. По количеству предложений." +
                "\n\tВ каждом предложении отсортировать слова по длине." +
                "\nВ каждом предложении отсортировать слова по длине." +
                "\n\tОтсортировать лексемы в предложении " +
                "по убыванию количества вхождений заданного символа. В случае равенства – по алфавиту.";

        Text inputText=new Text(inputString);

        new TextView().printlnText(inputText);

        TextHandler handler=new TextHandler(inputText);

        System.out.println("#1");
        String sortedParagraph=handler.getSortedByParagraph();
        System.out.println(sortedParagraph);

        System.out.println("#2");
        String sortedWord=handler.getSortedByWordGroups();
        System.out.println(sortedWord);

        System.out.println("#3");
        String sortedPoint=handler.getSortedByPoint();
        System.out.println(sortedPoint);



    }
}

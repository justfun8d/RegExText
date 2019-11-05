package by.epamtc.onlineCourse.main;

import by.epamtc.onlineCourse.logic.ParagraphLogic;

public class Paragraph extends Text implements Comparable{

    public Paragraph(String inputString){
        super(inputString);
    }

    @Override
    public int compareTo(Object o) {
        return new ParagraphLogic().compare(this, (Paragraph) o);
    }
}

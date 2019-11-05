package by.epamtc.onlineCourse.main;

import by.epamtc.onlineCourse.logic.ParagraphLogic;
import by.epamtc.onlineCourse.logic.PointLogic;
import by.epamtc.onlineCourse.logic.TextHandlerLogic;
import by.epamtc.onlineCourse.logic.WordLogic;

public class TextHandler {

    private Text text;

    public TextHandler(Text inputString){
        this.text=inputString;
    }

    String getSortedByParagraph(){
        return new ParagraphLogic().sortBySentenses(text);
    }

    String getSortedByWordGroups(){
        return new WordLogic().sortByWordGroup(text);
    }

    String getSortedByPoint(){
        return new PointLogic().sortByPointGroup(text);
    }
}

package by.epamtc.onlineCourse.logic;

import by.epamtc.onlineCourse.main.Paragraph;
import by.epamtc.onlineCourse.main.RegEx;
import by.epamtc.onlineCourse.main.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;

public class ParagraphLogic extends GeneralLogic {

    @Override
    public String sort(Text text) {
        return super.sort(text, true);
    }

    public String sortBySentenses(Text text){
        return sort(text);
    }

    private int getCountSentences(Paragraph paragraph){

        int counter=0;

        for (int i = 1; i < paragraph.getText().length(); i++) {
            if(paragraph.getText().charAt(i)=='.' && paragraph.getText().charAt(i-1)!='.'){
                counter++;
            }
        }

        return counter;
    }

    @Override
    public RegEx getExpression() {
        return new RegEx("\\t.+");
    }

    @Override
    public Text parseMatch(Matcher match) {
        return new Paragraph(match.group());
    }

    public int compare(Paragraph a, Paragraph b){
        return getCountSentences(a)-getCountSentences(b);
    }
}

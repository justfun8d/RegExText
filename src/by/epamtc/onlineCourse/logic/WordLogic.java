package by.epamtc.onlineCourse.logic;

import by.epamtc.onlineCourse.main.RegEx;
import by.epamtc.onlineCourse.main.Text;
import by.epamtc.onlineCourse.main.Word;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class WordLogic extends GeneralLogic {

    public String sortByWordGroup(Text text) {

        RegEx ex = new RegEx("[а-яА-я].+?\\.");

        ArrayList<Text> groupList = toList(text, ex);

        ArrayList<Text> groupSortedList = groupListSort(groupList);

        return toStringLn(groupSortedList);
    }



    @Override
    public RegEx getExpression() {
        return new RegEx("([а-яА-я^])+?\\b");
    }

    @Override
    public Text parseMatch(Matcher match) {
        return new Word(match.group());
    }

    public int compare(Word a, Word b) {
        return a.getText().length() - b.getText().length();
    }
}

package by.epamtc.onlineCourse.logic;

import by.epamtc.onlineCourse.main.Point;
import by.epamtc.onlineCourse.main.RegEx;
import by.epamtc.onlineCourse.main.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;

public class PointLogic extends GeneralLogic {

    public String sortByPointGroup(Text text) {

        String sortedByPoint=sortByPoint(text);

        StringBuilder str=new StringBuilder();


        return sortedByPoint;
    }

    public String sortByPoint(Text text) {

        RegEx exSentences = new RegEx("[а-яА-я].+?\\.");

        ArrayList<Text> groupSentenses = toList(text, exSentences);


        RegEx ex = new RegEx("[а-яА-я].+?[ \\.]");

        StringBuilder str=new StringBuilder();

        for (int i = 0; i < groupSentenses.size(); i++) {

            ArrayList<Text> groupList = toList(groupSentenses.get(i), ex);

            ArrayList<Text> groupSortedList = groupListSort(groupList);


            Text sortedSymbolsLiteral=new Text(toText(groupSortedList));

            sortedSymbolsLiteral=trimSpaces(sortedSymbolsLiteral);

            sortedSymbolsLiteral=sortByCountSymbols(sortedSymbolsLiteral);


            str.append(sortedSymbolsLiteral.getText());

            str.append("\n");
        }

        return str.toString();
    }

    public Text trimSpaces(Text text){

        Text trimText=new Text(text.getText().replaceAll("  ","*&*"));
        trimText.setText(trimText.getText().replaceAll(" ",""));
        trimText.setText(trimText.getText().replaceAll("\\*&\\*"," "));

        return trimText;
    }

    public Text sortByCountSymbols(Text text){

        RegEx ex=new RegEx(".+");

        Matcher match=super.getMatcher(text, this.getExpression());

        ArrayList<Text> list=new ArrayList<>(toList(match));

        Collections.sort(list);

        return text;
    }

    @Override
    public RegEx getExpression() {
        return new RegEx("[a-яА-Я]");
    }

    @Override
    public Text parseMatch(Matcher match) {
        return new Point(match.group());
    }

    public int compare(Point aInput, Point bInput){

        char a=aInput.getText().charAt(0);
        char b=bInput.getText().charAt(0);

        if(a>='А' && a>='Я'){
            a-=32;
        }

        if(b>='А' && b>='Я'){
            b-=32;
        }

        if(a>b){
            return 1;
        } else if(a<b){
            return -1;
        } else{
            return 0;
        }
    }
}

package by.epamtc.onlineCourse.logic;

import by.epamtc.onlineCourse.main.RegEx;
import by.epamtc.onlineCourse.main.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class GeneralLogic {

    public abstract RegEx getExpression();

    public abstract Text parseMatch(Matcher match);


    public String sort(Text text){
        boolean isNewLine=false;

        sort(text, isNewLine);

        return sort(text, isNewLine);
    }

    public String sort(Text text, boolean isNewLine){

        Matcher match=this.getMatcher(text, this.getExpression());

        ArrayList<Text> list=new ArrayList<>(toList(match));

        Collections.sort(list);

        if(isNewLine){
            return toStringLn(list);
        } else{
            return toText(list);
        }
    }

    public ArrayList<Text> toList(Matcher matcher){

        ArrayList<Text> list=new ArrayList<>();

        while (matcher.find()){

            Text matchText=parseMatch(matcher);
            list.add(matchText);
        }

        return list;
    }

    public ArrayList<Text> toList(Text text, RegEx ex) {

        Matcher match = this.getMatcher(text, ex);

        ArrayList<Text> list = new ArrayList<>(this.toList(match));

        return list;
    }

    public ArrayList<Text> groupListSort(ArrayList<Text> listIn) {

        ArrayList<Text> list = new ArrayList<>();

        for (int i = 0; i < listIn.size(); i++) {

            Text iText = new Text(sort(listIn.get(i)));

            list.add(iText);
        }

        return list;

    }


    public Matcher getMatcher(Text text, RegEx expression){

        Pattern pattern = Pattern.compile(expression.getExpression());
        Matcher matcher = pattern.matcher(text.getText());

        return matcher;
    }

    public String toText(ArrayList<Text> list){

        StringBuilder builder=new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i).getText()+" ");
        }

        return builder.toString();
    }

    public String toStringNoSp(ArrayList<Text> list){

        StringBuilder builder=new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i).getText());
        }

        return builder.toString();
    }

    public String toStringLn(ArrayList<Text> list){

        StringBuilder builder=new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i).getText()+"\n");
        }

        return builder.toString();
    }

}

package by.epamtc.onlineCourse.view;

import by.epamtc.onlineCourse.main.Text;

import java.util.ArrayList;

public class TextView {

    public void printText(Text text){
        System.out.println(text.getText());
    }

    public void printlnText(Text text){
        printText(text);
        System.out.println();
    }

    public void print(Text text){
        System.out.println(text);
    }

    public void print(ArrayList<Text> text){

        for (Text iText : text) {
            System.out.println(iText);
        }
    }
}

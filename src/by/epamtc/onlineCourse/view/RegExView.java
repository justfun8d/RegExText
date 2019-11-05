package by.epamtc.onlineCourse.view;

import by.epamtc.onlineCourse.main.RegEx;

public class RegExView {

    public void printRegEx(RegEx expression){
        System.out.println(expression.getExpression());
    }

    public void printlnRegEx(RegEx expression){
        printRegEx(expression);
        System.out.println();
    }
}

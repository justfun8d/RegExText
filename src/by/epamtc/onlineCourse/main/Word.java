package by.epamtc.onlineCourse.main;

import by.epamtc.onlineCourse.logic.WordLogic;
public class Word extends Text implements Comparable{

    public Word(String inputString){
        super(inputString);
    }

    @Override
    public int compareTo(Object o) {
        return new WordLogic().compare(this, (Word) o);
    }
}

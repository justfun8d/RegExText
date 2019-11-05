package by.epamtc.onlineCourse.main;

import by.epamtc.onlineCourse.logic.PointLogic;

public class Point extends Text implements Comparable{

    public Point(String inputString){
        super(inputString);
    }

    @Override
    public int compareTo(Object o) {
        return new PointLogic().compare(this, (Point) o);
    }
}

package by.epamtc.onlineCourse.main;

public class Text implements Comparable{

    private String text;

    public Text(String inputText){
        this.text=inputText;
    }

    public String getText(){
        return this.text;
    }

    public void setText(String text){
        this.text=text;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

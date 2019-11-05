package by.epamtc.onlineCourse.logic;

import by.epamtc.onlineCourse.main.RegEx;
import by.epamtc.onlineCourse.main.Sentence;
import by.epamtc.onlineCourse.main.Text;

import java.util.regex.Matcher;

public class SentenceLogic extends GeneralLogic {

    @Override
    public RegEx getExpression() {
        return new RegEx("[а-яА-я].+?\\.");
    }

    @Override
    public Text parseMatch(Matcher match) {
        return new Sentence(match.group());
    }
}

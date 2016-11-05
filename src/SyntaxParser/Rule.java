package SyntaxParser;

import java.util.*;

/**
 * Created by st0001 on 2016/11/5.
 */
public class Rule {

    ParsingSymbol left;
    List<ParsingSymbol> right;


    public Rule(ParsingSymbol left, List<ParsingSymbol> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String s = left+" -> ";
        for (ParsingSymbol str:right)
            s += str+" ";
        return s;
    }
}

package DFA;

/**
 * Created by Dora on 2016/10/22.
 */

public class SymbolAnalyzer {

    private static  final char operators[] = { '+', '-', '*', '/', '=', '>', '<', '&' };
    private static final char separators[] = { ',', ';', '{', '}', '(', ')', '[', ']',
            ':', '.', '"' };

    public static Symbol analyze(char ch) {
        if (isLetter_(ch))
            return Symbol.letter_;
        else if (isDigit(ch))
            return Symbol.digit;
        else if (ch == '+')
            return Symbol.add;
        else if (ch == '-')
            return Symbol.minus;
        else if (ch == '=')
            return Symbol.equal;
        else if (ch == '.')
            return Symbol.dot;
        else if (ch == '/')
            return Symbol.slash;
        else if (ch == '!')
            return Symbol.exclamation;
        else if (ch == '"')
            return Symbol.quote;
        else if (ch == '*')
            return Symbol.star;
        else if (isOperator(ch))
            return Symbol.operator;
        else if (isSeparator(ch))
            return Symbol.separator;
        return Symbol.none;
    }

    private static boolean isLetter_(char ch) {
        return Character.isLetter(ch)||ch=='_';
    }
    /*/c*****/
    private static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private static boolean isOperator(char ch) {
        for(char op: operators){
            if(op == ch)
                return true;
        }
        return false;
    }

    private static boolean isSeparator(char ch) {
        for(char sepa: separators){
            if(sepa == ch)
                return true;
        }
        return false;
    }

}

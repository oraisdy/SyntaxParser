package DFA;

/**
 * Created by Dora on 2016/10/22.
 */
public class Token {
    private String input;
    private int current;
    private int previous;

    public Token(String input) {
        this.input = input;
        this.current = 0;
    }

    public int getCurrent(){
        return current;
    }

    public void setPrevious(int i) {
        previous = i;
    }

    public String getWord() {
        return input.substring(previous,current);
    }

    public Symbol next() {
        return SymbolAnalyzer.analyze(input.charAt(current++));
    }

    public boolean hasNext() {
        return current < input.length();
    }

    public void back() {
        current --;
    }
}

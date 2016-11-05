import java.util.*;

/**
 * Created by st0001 on 2016/11/5.
 */
public class Rule {

    NonTerminal left;
    List<Symbol> right;

    public Rule(String str, List<Symbol> symbols) {
        String[] splits = str.trim().split("->");
        this.left = new NonTerminal(splits[0]);
        this.right = new Stack<>();

    }

    public Rule(NonTerminal left, List<Symbol> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left+"->"+right.toString();
    }
}

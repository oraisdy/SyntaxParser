import java.util.List;
import java.util.Stack;

/**
 * Created by st0001 on 2016/11/5.
 */
public class Controller {
    NonTerminal nonTerminal;
    Terminal terminal;
    Stack<NonTerminal> stack;
    List<String> tokens;

    public Controller( List<String> tokens) {
        this.stack = new Stack<>();
        stack.push(new NonTerminal("$"));

        this.tokens = tokens;
    }

    public void pushRule(Rule rule) {
        stack.pop();
        for (int i = rule.right.size()-1;i>=0;i--) {

        }
    }

    //    public boolean match(){
//        return nonTerminal
//    }


}

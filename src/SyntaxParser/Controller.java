package SyntaxParser;

import java.util.*;

/**
 * Created by st0001 on 2016/11/5.
 */
public class Controller {
    Stack<ParsingSymbol> stack;
    List<ParsingSymbol> tokens;
    int current;
    ParsingTable table;

    public Controller(List<ParsingSymbol> tokens, ParsingTable table) {
        this.stack = new Stack<>();
        stack.push(new ParsingSymbol("$"));
        stack.push(table.states.get(0));
        this.tokens = tokens;
        this.tokens.add(new ParsingSymbol("$"));
        this.table = table;
        current = -1;
    }

    public void execute() {
       while(nextToken()) {
//           System.out.println(tokens.get(current));
            while (!match()) {
                Rule rule = stack.peek().getRule(table, tokens.get(current));
                System.out.println(rule);
                List<ParsingSymbol> list = new ArrayList<>(rule.right);
                stack.pop();
                if(!(list.size()==1 && list.get(0).name.equals("ε"))){
                    Collections.reverse(list);
                    stack.addAll(list);
                }

//                System.out.print("stack:");
//                for (SyntaxParser.ParsingSymbol symbol:stack)
//                    System.out.print(symbol+" ");
//                System.out.println();
//                System.out.println("====");
            }
           stack.pop();
        }

    }

    private boolean match(){
//        System.out.println("matching:"+stack.peek()+" "+tokens.get(current)+" "+stack.peek().name.equals(tokens.get(current).name));
        return stack.peek().equals(tokens.get(current));
    }


    private boolean nextToken(){
        return ++current < tokens.size();
    }




}

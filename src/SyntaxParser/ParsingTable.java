package SyntaxParser;

import java.util.List;

/**
 * Created by st0001 on 2016/11/5.
 *
 * SyntaxParser.ParsingTable[STATE][ACTION]=SyntaxParser.Rule
 */
public class ParsingTable {

    int[][] table;
    List<ParsingSymbol> states;
    List<ParsingSymbol> actions;
    List<Rule> rules;

    public ParsingTable(int[][] table, List<ParsingSymbol> states, List<ParsingSymbol> actions, List<Rule> rules) {
        this.table = table;
        this.states = states;
        this.actions = actions;
        this.rules = rules;
    }

    public Rule getRule(ParsingSymbol state, ParsingSymbol action) {
        int row = states.indexOf(state);
        int colomn = actions.indexOf(action);
        return table[row][colomn] > 0 ?rules.get(table[row][colomn]-1):null;
    }
}

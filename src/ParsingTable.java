import java.util.List;

/**
 * Created by st0001 on 2016/11/5.
 *
 * ParsingTable[STATE][ACTION]=Rule
 */
public class ParsingTable {

    int[][] table;
    List<NonTerminal> states;
    List<Terminal> actions;
    List<Rule> rules;

    public ParsingTable(int[][] table, List<NonTerminal> states, List<Terminal> actions) {
        this.table = table;
        this.states = states;
        this.actions = actions;
    }

    public Rule getRule(NonTerminal state, Terminal action) {
        int row = states.indexOf(state);
        int colomn = actions.indexOf(action);
        return table[row][colomn] > 0 ?rules.get(table[row][colomn]-1):null;
    }
}

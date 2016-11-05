/**
 * Created by st0001 on 2016/11/5.
 */
public class NonTerminal extends Symbol {


    public NonTerminal(String name) {
        super(name);
    }

    public Rule getRule(ParsingTable table, Terminal action){
        return table.getRule(this,action);
    }

    @Override
    public String toString() {
        return "NonTerminal{" +
                "name='" + name + '\'' +
                '}';
    }
}

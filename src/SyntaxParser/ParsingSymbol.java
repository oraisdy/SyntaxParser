package SyntaxParser;

/**
 * Created by st0001 on 2016/11/5.
 */
public class ParsingSymbol {

    protected String name;

    public ParsingSymbol(String name) {
        this.name = name;
    }

    public Rule getRule(ParsingTable table, ParsingSymbol action){
        return table.getRule(this,action);
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParsingSymbol parsingSymbol = (ParsingSymbol) o;

        return name != null ? name.equals(parsingSymbol.name) : parsingSymbol.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

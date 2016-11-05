/**
 * Created by st0001 on 2016/11/5.
 */
public class Symbol {

    protected String name;

    public Symbol(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "name='" + name + '\'' +
                '}';
    }
}

/**
 * Created by st0001 on 2016/11/5.
 */
public class Terminal extends Symbol {

    public Terminal(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Terminal{" +
                "name='" + name + '\'' +
                '}';
    }
}

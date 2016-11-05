package DFA;

/**
 * Created by Dora on 2016/10/22.
 */
public interface State {

    public State next(Token token);
}

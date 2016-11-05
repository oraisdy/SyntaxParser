package DFA;

/**
 * Created by Dora on 2016/10/22.
 */
public class OriginState implements State {
    @Override
    public State next(Token token) {
        if(token.hasNext()) {
            switch (token.next()) {
                case letter_:return States.A;
                case digit:return States.B;
                case separator:return States.C;
                case add:return States.D;
                case minus:return States.E;
                case equal:return States.F;
                case exclamation:return States.G;
                case slash:return States.H;
                case quote:return States.I;
            }
        }
        return FinalState.accept;
    }
}

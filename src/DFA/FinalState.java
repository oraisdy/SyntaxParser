package DFA;

/**
 * Created by Dora on 2016/10/22.
 */
public enum FinalState implements State{

    identifier,
    reserved,
    integer,
    decimal,
    separator,
    arithmeticOperator,
    relationalOperator,
    assignmentOperator,
    operator,
    comment,
    string,
    accept,
    error;

    @Override
    public State next(Token token) {
        return null;
    }

}

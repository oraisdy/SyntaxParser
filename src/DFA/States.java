package DFA;

/**
 * Created by Dora on 2016/10/22.
 */
public enum States implements State {

    A{
        @Override
        public State next(Token token) {
            if(token.hasNext()){
                switch(token.next()) {
                    case letter_:
                        return A;
                    case digit:
                        return A;
                    default:
                        token.back();
                        for(String word:reservedWord) {
                            if (token.getWord().equals(word))
                                return FinalState.reserved;
                        }
                        return FinalState.identifier;
                }
            }
            return FinalState.error;//can't end the code with a letter or digit
        }
    },

    B{
        @Override
        public State next(Token token) {
            if(token.hasNext()){
                switch (token.next()) {
                    case digit:
                        return J;
                    case dot:
                        return K;
                    default:
                        token.back();
                        return FinalState.integer;
                }
            }
            return FinalState.error; //can't end the code with an operator
        }
    },

    C {
        @Override
        public State next(Token token) {
            return FinalState.separator;
        }
    },

    D {
        @Override
        public State next(Token token) {
            if(token.hasNext()) {
                switch (token.next()) {
                    case add: return FinalState.operator;
                    case equal:return FinalState.assignmentOperator;
                    default:token.back();
                        return FinalState.arithmeticOperator;
                }
            }
            return FinalState.error;
        }
    },

    E {
        @Override
        public State next(Token token) {
            if(token.hasNext()) {
                switch (token.next()) {
                    case minus: return FinalState.operator;
                    case equal:return FinalState.assignmentOperator;
                    default:token.back();
                        return FinalState.arithmeticOperator;
                }
            }
            return FinalState.error;
        }
    },

    F {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case equal:
                        return FinalState.relationalOperator;
                    default:
                        token.back();
                        return FinalState.assignmentOperator;
                }
            }
            return FinalState.error;
        }
    },

    G {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case equal:
                        return FinalState.relationalOperator;
                    default:
                        token.back();
                        return FinalState.error;
                }
            }
            return FinalState.error;
        }
    },

    H {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case star:
                        return N;
                    default:
                        token.back();
                        return FinalState.operator;
                }
            }
            return FinalState.error;
        }
    },

    I {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case quote:
                        return FinalState.string;
                    default:
                        return I;
                }
            }
            return FinalState.error;
        }
    },

    J {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case digit:
                        return J;
                    default:
                        token.back();
                        return FinalState.integer;
                }
            }
            return FinalState.error;
        }
    },

    K {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case digit:
                        return L;
                    default:
                        token.back();
                        return FinalState.error;
                }
            }
            return FinalState.error;
        }
    },
    L {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case digit:
                        return L;
                    default:
                        token.back();
                        return FinalState.decimal;
                }
            }
            return FinalState.error;
        }
    },

    N {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case star:
                        return O;
                    default:
                        return N;
                }
            }
            return FinalState.error;
        }
    },

    O {
        @Override
        public State next(Token token) {
            if (token.hasNext()) {
                switch (token.next()) {
                    case slash:
                        return FinalState.comment;
                    default:
                        return N;
                }
            }
            return FinalState.error;
        }
    };

    private static final String reservedWord[] = { "abstract", "boolean", "break", "byte",
            "case", "catch", "char", "class", "continue", "default", "do",
            "double", "else", "extends", "final", "finally", "float", "for",
            "if", "implements", "import", "instanceof", "int", "interface",
            "long", "native", "new", "package", "private", "protected",
            "public", "return", "short", "static", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while", "strictfp","enum","goto","const","assert" };
}

package DFA;

import SyntaxParser.ParsingSymbol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2016/11/6.
 */
public class DFA {

    String str;

    public DFA(String s) {
        this.str = s;

    }

    public List<ParsingSymbol> generate() {
        Token in = new Token(str);
        State s;
        List<ParsingSymbol> tokens = new ArrayList<>();
        try {
            //output
            File outputFile = new File("tokens.txt");
            if (!outputFile.exists())
                outputFile.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, false));


            while (in.hasNext()) {
                for (s = new OriginState(); !(s instanceof FinalState); s = s.next(in)) {
                }

                if (s == FinalState.accept) {
                } else {
                    if (s != FinalState.reserved && s != FinalState.separator) {
//                        System.out.println(s + "\t\t" + in.getWord());
                        tokens.add(new ParsingSymbol(s.toString()));
                        bw.write(s + "\t\t" + in.getWord());
                    } else {
//                        System.out.println(in.getWord() + "\t\t" + in.getWord());
                        tokens.add(new ParsingSymbol(in.getWord()));
                        bw.write(in.getWord() + "\t\t" + in.getWord());
                    }

                    bw.newLine();
                }
                in.setPrevious(in.getCurrent());


            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tokens;
    }
}

import DFA.FinalState;
import DFA.OriginState;
import DFA.State;
import DFA.Token;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by st0001 on 2016/11/5.
 */
public class Main {

    public static void main(String[] args) {
//        try {
//
//            //get input
//            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
//            String line;
//            String str = "";
//            while((line = reader.readLine()) != null )
//                str += line;
//
//            Token in = new Token(str);
//            State s;
//
//            //output
//            File outputFile = new File("tokens.txt");
//            if (!outputFile.exists())
//                outputFile.createNewFile();
//            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, false));
//
//
//            while(in.hasNext()){
//                for (s = new OriginState(); !(s instanceof FinalState); s = s.next(in)) {
//                }
//
//                if(s==FinalState.accept) {
//                }
//                else {
//                    if (s!=FinalState.reserved && s!=FinalState.separator) {
//                        System.out.println(s + "\t\t" + in.getWord());
//                        bw.write(s + "\t\t" + in.getWord());
//                    } else {
//                        System.out.println(in.getWord() + "\t\t" + in.getWord());
//                        bw.write(in.getWord() + "\t\t" + in.getWord());
//                    }
//
//                    bw.newLine();
//                }
//                in.setPrevious(in.getCurrent());
//
//            }
//
//            bw.flush();
//            bw.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        List<Rule> rules = new ArrayList<>();
        List<Terminal> terminals = new ArrayList<>();
        List<NonTerminal> nonTerminals = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("table.txt")));
            for(String terminal:reader.readLine().split(" "))
                terminals.add(new Terminal(terminal));


            BufferedReader rulesReader = new BufferedReader(new InputStreamReader(new FileInputStream("rules.txt")));
            String line;
            while ((line = rulesReader.readLine()) != null) {
                List<Symbol> list = new ArrayList<>();
                NonTerminal nonTerminal = new NonTerminal(line.split(" ")[0].trim());
                for(String symbol: line.split(" -> ")[1].split(" "))
                    list.add(new Symbol(symbol));
                rules.add(new Rule(nonTerminal,list));
            }

            int[][] table = new int[rules.size()][terminals.size()];
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                nonTerminals.add(new NonTerminal(line.split(" ")[0]));
                System.out.println(line);
                for (int i = 1; i<line.split(" ").length;i++)
                    table[lineNum][i-1] = Integer.parseInt(line.split(" ")[i]);
                lineNum ++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(terminals);
        System.out.println(nonTerminals);
        System.out.println(rules);


    }
}

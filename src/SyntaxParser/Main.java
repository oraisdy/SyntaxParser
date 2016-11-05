package SyntaxParser;

import DFA.DFA;


import java.io.*;
import java.util.*;

/**
 * Created by st0001 on 2016/11/5.
 */
public class Main {

    public static void main(String[] args) {


        try {


            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            String line;
            String str = "";
            while ((line = reader.readLine()) != null)
                str += line;

            DFA dfa = new DFA(str);
            List<ParsingSymbol> tokens = dfa.generate();


            List<Rule> rules = new ArrayList<>();
            List<ParsingSymbol> terminals = new ArrayList<>();
            List<ParsingSymbol> nonTerminals = new ArrayList<>();


            BufferedReader tableReader = new BufferedReader(new InputStreamReader(new FileInputStream("table.txt")));
            for (String terminal : tableReader.readLine().split(" "))
                terminals.add(new ParsingSymbol(terminal));


            BufferedReader rulesReader = new BufferedReader(new InputStreamReader(new FileInputStream("rules.txt")));
            while ((line = rulesReader.readLine()) != null) {
                List<ParsingSymbol> list = new ArrayList<>();
                ParsingSymbol nonTerminal = new ParsingSymbol(line.split(" ")[0].trim());
                for (String symbol : line.split(" -> ")[1].split(" "))
                    list.add(new ParsingSymbol(symbol));
                rules.add(new Rule(nonTerminal, list));
            }

            int[][] table = new int[rules.size()][terminals.size()];
            int lineNum = 0;
            while ((line = tableReader.readLine()) != null) {
                nonTerminals.add(new ParsingSymbol(line.split(" ")[0]));
                for (int i = 1; i < line.split(" ").length; i++)
                    table[lineNum][i - 1] = Integer.parseInt(line.split(" ")[i]);
                lineNum++;
            }

            ParsingTable pt = new ParsingTable(table, nonTerminals, terminals, rules);

//            System.out.println(terminals);
//            System.out.println(nonTerminals);
//            System.out.println(rules);

            Controller controller = new Controller(tokens, pt);
            controller.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

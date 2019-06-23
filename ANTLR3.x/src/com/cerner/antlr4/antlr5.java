package com.cerner.antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class antlr5 {

    /**
     * The main method.
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final String sql = "SELECT DISPENSE_ID FROM DISPENSE_HX WHERE DISPENSE_ID = 123";

        final MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(sql.toUpperCase()));
        final CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        final MySqlParser mySqlParser = new MySqlParser(tokens);

        final ParseTree tree = mySqlParser.dmlStatement();

        System.out.println(tree.toStringTree(mySqlParser));
    }

}

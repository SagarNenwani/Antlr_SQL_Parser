package com.cerner.antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class antlr4 {

    /**
     * The main method.
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final String sql = "SELECT DISPENSE_ID FROM DISPENSE_HX WHERE DISPENSE_ID = 123";

        final MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(sql.toUpperCase()));
        final CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);

        // Create a parser that feeds off the tokens buffer
        final MySqlParser mySqlParser = new MySqlParser(tokens);

        // Begin parsing at rule prog
        final ParseTree tree = mySqlParser.dmlStatement();

        // // Close the input file
        // fis.close();

        // Create a generic parse tree walker that can trigger callbacks
        final ParseTreeWalker walker = new ParseTreeWalker();
        // Walk the tree created during the parse, trigger callbacks

        walker.walk(new MySqlListener(), tree);
        System.out.println(); // print a \n after translation

        // Walk the tree again to translate to java
        walker.walk(new MySqlTranslator(), tree);

        // final ParseTree tree = mySqlParser.dmlStatement();
        //
        // System.out.println(tree.toStringTree(mySqlParser));
    }

}

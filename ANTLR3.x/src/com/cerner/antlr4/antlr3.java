package com.cerner.antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class antlr3 {

    /**
     * The main method.
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final String sql = "SELECT DISPENSE_ID FROM DISPENSE_HX WHERE DISPENSE_ID = 123";

        // final String sql = "select dispense_hx_id, disp_event_type_cd,\r\n" + " dispense_dt_tm, \r\n" + " dispense_prsnl_id prsnl_id,\r\n" + " \r\n" + "from \r\n" + "dispense_hx \r\n"
        // + "where dispense_hx_id = 123";

        final MySqlLexer mySqlLexer = new MySqlLexer(CharStreams.fromString(sql.toUpperCase()));
        final CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        final MySqlParser mySqlParser = new MySqlParser(tokens);

        final ParseTree tree = mySqlParser.dmlStatement();

        // final TableNameContext t2 = mySqlParser.tableName();

        // System.out.println(t2.toString());

        System.out.println(tree.toStringTree(mySqlParser));
        // System.out.println(t2.toStringTree(mySqlParser));

        // final ANTLRInputStream input = new ANTLRInputStream(sql);
        // final MySqlLexer mySqlLexer = new MySqlLexer(input);
        // final CommonTokenStream tokens = new CommonTokenStream(mySqlLexer);
        // final MySqlParser mySqlParser = new MySqlParser(tokens);
        //
        // final ParseTree tree = mySqlParser.dmlStatement();
        // final ParseTreeWalker walker = new ParseTreeWalker();
        // final MySqlParserBaseListener listener = new MySqlParserBaseListener();
        // ParseTreeWalker.DEFAULT.walk(listener, tree);

        // final MySqlLexer lexer = new MySqlLexer(CharStreams.fromString(sql));
        // final MySqlParser parser = new MySqlParser(new CommonTokenStream(lexer));
        // final ParseTree root = parser.dmlStatement();
        //
        // System.out.println(root.toStringTree(parser));

    }

}

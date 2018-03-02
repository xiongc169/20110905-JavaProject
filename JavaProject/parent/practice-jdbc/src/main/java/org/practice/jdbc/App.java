package org.practice.jdbc;

import java.io.StringReader;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
	{
		// SQLParser parser=new SQLParser();
    	try {
			Statement stmt=new CCJSqlParserManager().parse(new StringReader(""));
		} catch (JSQLParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println( "Hello World!" );
    }
}

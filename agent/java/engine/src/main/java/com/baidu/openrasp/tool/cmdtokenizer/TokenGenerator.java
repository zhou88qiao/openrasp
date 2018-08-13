package com.baidu.openrasp.tool.cmdtokenizer;


import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import java.util.ArrayList;

/**
 * Created by lxk on 3/19/18.
 */
public class TokenGenerator {

    /**
     *
     * tokenize query clause
     * @param text query clause
     * @return tokens
     */
    public static String[] tokenize (String text)
    {
        ANTLRInputStream input   = new ANTLRInputStream(text);
        BashJava lexer   = new BashJava(input);
        ArrayList<String> result = new ArrayList<String>();
        for (Token token = lexer.nextToken();
             token.getType() != Token.EOF;
             token = lexer.nextToken())
        {
            result.add(token.getText());
        }
        if(lexer.token_error > 0){
            result.add("token_error");
        }
        else{
            result.add("token_correct");
        }
        return result.toArray(new String[0]);
    }
}

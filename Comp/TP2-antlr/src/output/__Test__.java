import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        VSLLexer lex = new VSLLexer(new ANTLRFileStream("/private/student/0/90/25003090/Bureau/test grammaire/tp1.ttl", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

 g = new (tokens, 49100, null);
        try {
            g.WS();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
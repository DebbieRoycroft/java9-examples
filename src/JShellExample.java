import jdk.jshell.*;

import java.util.List;
import java.util.stream.Collectors;

public class JShellExample {
    public static void main(String[] args) {
        //JShell has an API that can be invoked programmatically

        //Get an instance of the shell via the builder
        JShell shell = JShell.create();
        //Use eval to submit input to the shell
        List<SnippetEvent> snippets = shell.eval("System.out.println(\"hello world\"");

        //SnippetEvents returned can then be interrogated to find out if input was successful
        for(SnippetEvent snippet : snippets){
            System.out.println( snippet.status());
            System.out.println( snippet.snippet().source());

            List<Diag> diag = shell.diagnostics(snippet.snippet()).collect(Collectors.toList());
            diag.forEach(System.out::println);
        }


    }

}

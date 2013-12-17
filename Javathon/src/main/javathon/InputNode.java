package main.javathon;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class handles the input from the user.
 * @author G301
 *
 */
public class InputNode implements JNode {

    private String prompt;
    private PrintStream out;

    public InputNode(String p) {
        this(p, System.out);
    }

    public InputNode(String p, PrintStream o) {
        prompt = (p == null) ? "" : p;
        out = o;
    }

    @Override
    public JValue evaluate() {
        out.print(prompt);
        Scanner keyboard = new Scanner(System.in);

        if(keyboard.hasNextDouble()) 
            return new JValue(Double.valueOf(keyboard.nextDouble()));
        else if(keyboard.hasNextInt()) 
            return new JValue(Integer.valueOf(keyboard.nextInt()));
        else if(keyboard.hasNextBoolean()) 
            return new JValue(Boolean.valueOf(keyboard.nextBoolean()));
        else 
            return new JValue(keyboard.nextLine().trim()); // else it's a plain string
    }
}
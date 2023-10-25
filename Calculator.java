package calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        System.out.println("Welcome to the Command-Line Calculator!");
        System.out.println("You can perform arithmetic operations (+, -, *, /).");
        System.out.println("Enter 'exit' to quit the calculator.");

        while (true) {
            System.out.print("Enter an expression: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                Object result = engine.eval(input);
                System.out.println("Result: " + result);
            } catch (ScriptException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

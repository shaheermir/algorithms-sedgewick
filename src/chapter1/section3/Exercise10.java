package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise10 {
  public static void main(String[] args) {

    String infix1 = "( 1 + 2 )";
    String postfix1 = "1 2 +";
    StdOut.println("Infix: " + infix1 + " | Expected Postfix: " + postfix1);
    StdOut.println(infixToPostfix(infix1));

    StdOut.println();

    String infix2 = "( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )";
    String postfix2 = "2 3 4 + 5 6 * * + ";
    StdOut.println("Infix: " + infix2 + " | Expected Postfix: " + postfix2);
    StdOut.println(infixToPostfix(infix2));
  }

  private static String infixToPostfix(String infixExpression) {
    String[] values = infixExpression.split("\\s");

    Stack<String> operands = new Stack<>();
    Stack<String> operators = new Stack<>();

    for (String value : values) {
      if (value.equals("(")) continue;

      if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
        operators.push(value);
      } else if (value.equals(")")) {
        String value1 = operands.pop();
        String value2 = operands.pop();
        String operator = operators.pop();

        String combinedExpression = value2 + " " + value1 + " " + operator;
        operands.push(combinedExpression);
      } else {
        operands.push(value);
      }
    }
    return operands.pop();
  }
}

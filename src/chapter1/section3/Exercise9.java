package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise9 {

  public static void main(String[] args) {
    String expression1 = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
    StdOut.println(getInfixExpression(expression1));
  }

  private static String getInfixExpression(String input) {
    String[] values = input.split("\\s");

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

        String expression = "( " + value2 + " " + operator + " " + value1 + " )";
        operands.push(expression);
        StdOut.println(expression);
      } else {
        operands.push(value);
      }
    }

    return operands.pop();
  }
}

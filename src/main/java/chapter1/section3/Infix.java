package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

// Ex 9
public class Infix {
  public static String getInfixExpression(String input) {
    String[] values = input.split("\\s");
    Stack<String> operands = new Stack<>();
    Stack<String> operators = new Stack<>();

    for (String val : values) {
      if (val.equals("(")) continue;

      if (val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")) {
        operators.push(val);
      } else if (val.equals(")")) {
        String value1 = operands.pop();
        String value2 = operands.pop();
        String operator = operators.pop();

        String expression = "( " + value1 + " " + operator + " " + value2 + " )";
        operands.push(expression);

      } else {
        operands.push(val);
      }
    }

    return operands.pop();
  }

  public static void main(String[] args) {
    String expression1 = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
    StdOut.println(getInfixExpression(expression1));
  }
}

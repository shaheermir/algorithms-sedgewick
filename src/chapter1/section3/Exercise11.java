package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise11 {
  public static void main(String[] args) {

    String postfix1 = "1 2 +";
    StdOut.println("Postfix: " + postfix1 + " | Expected Result: " + 3);
    StdOut.println(evaluatePostfix(postfix1));

    StdOut.println();

    String postfix2 = "7 16 16 16 * * * 5 16 16 * * 3 16 * 1 + + +";
    StdOut.println("Postfix: " + postfix2 + " | Expected Result: " + 30001);
    StdOut.println(evaluatePostfix(postfix2));
  }

  private static int evaluatePostfix(String postfix) {
    String[] values = postfix.split("\\s");
    Stack<Integer> operands = new Stack<>();

    for (String v : values) {
      if (v.equals("+")) operands.push(operands.pop() + operands.pop());
      else if (v.equals("*")) operands.push(operands.pop() * operands.pop());
      else operands.push(Integer.parseInt(v));
    }

    return operands.pop();
  }
}

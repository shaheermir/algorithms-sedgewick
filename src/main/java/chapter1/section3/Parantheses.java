package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

// Ex 4
public class Parantheses {
  public static boolean isBalanced(String paranthesesText) {
    char[] paranthesesArray = paranthesesText.toCharArray();
    Stack<Character> stack = new Stack<Character>();

    for (char p : paranthesesArray) {
      if (p == '[' || p == '{' || p == '(') {
        stack.push(p);
      } else {
        if (stack.isEmpty()) return false;

        char closingP = p;
        char openingP = stack.pop();

        if ((closingP == ']' && openingP != '[')
            || (closingP == '}' && openingP != '{')
            || (closingP == ')' && openingP != '(')) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String p1 = "(){}[]";
    String p2 = "[{}()]";
    String p3 = "[(){}]{}(())";
    String p4 = "()[]]";

    StdOut.printf("Pattern: %s - Result: %b - Expected: %b\n", p1, isBalanced(p1), true);
    StdOut.printf("Pattern: %s - Result: %b - Expected: %b\n", p2, isBalanced(p2), true);
    StdOut.printf("Pattern: %s - Result: %b - Expected: %b\n", p3, isBalanced(p3), true);
    StdOut.printf("Pattern: %s - Result: %b - Expected: %b\n", p4, isBalanced(p4), false);
  }
}

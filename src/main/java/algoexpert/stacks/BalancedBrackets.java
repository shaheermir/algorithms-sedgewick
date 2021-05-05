package algoexpert.stacks;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class BalancedBrackets {

  public static boolean balancedBrackets(String str) {
    char[] pArray = str.toCharArray();
    Stack<Character> stack = new Stack<>(); // lifo

    for (char p : pArray) {
      if (p == '(' || p == '{' || p == '[') {
        stack.push(p);
      } else if (p == ')' || p == '}' || p == ']') {
        if (stack.isEmpty()) return false;

        char openingP = stack.pop();

        if (openingP == '(' && p != ')') return false;
        if (openingP == '{' && p != '}') return false;
        if (openingP == '[' && p != ']') return false;
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String p = "([])(){}(())()()";
    String p2 = "(2)";
    String p3 = "(){}[](";

    StdOut.println(balancedBrackets(p));
    StdOut.println(balancedBrackets(p2));
    StdOut.println(balancedBrackets(p3));
  }
}

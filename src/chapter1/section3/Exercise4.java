package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {
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

    private static boolean isBalanced(String parenthesesText) {
        char[] parenthesesArray = parenthesesText.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char p : parenthesesArray) {
            if (p == '[' || p == '{' || p == '(') {
                stack.push(p);
            } else {
                if (stack.isEmpty()) return false;

                char closingP = p;
                char openingP = stack.pop();

                if ((closingP == ']' && openingP != '[') || (closingP == '}' && openingP != '{') || (closingP == ')' && openingP != '(')
                ) {
                    return false;
                }
            }
        }
        return true;
    }
}

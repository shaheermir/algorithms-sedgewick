package chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals("+")) operators.push(s);
            else if (s.equals("-")) operators.push(s);
            else if (s.equals("*")) operators.push(s);
            else if (s.equals("/")) operators.push(s);
            else if (s.equals("sqrt")) operators.push(s);
            else if (s.equals(")")) {
                String operator = operators.pop();
                double v = operands.pop();
                if (operator.equals("+")) v = operands.pop() + v;
                else if (operator.equals("-")) v = operands.pop() - v;
                else if (operator.equals("*")) v = operands.pop() * v;
                else if (operator.equals("/")) v = operands.pop() / v;
                else if (operator.equals("sqrt")) v = Math.sqrt(v);
                operands.push(v);
            } else
                operands.push(Double.parseDouble(s));
        }
        StdOut.println(operands.pop());
    }
}

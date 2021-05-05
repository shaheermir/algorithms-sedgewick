package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise9 {
  public static String intToBinary(int n) {
    String result = "";

    while (n > 0) {
      result = n % 2 + result;
      n = n / 2;
    }
    return result;
  }

  public static void main(String[] args) {
    StdOut.println(intToBinary(13));
    StdOut.println("Expected: 100");
  }
}

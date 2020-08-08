package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

/**
 * See
 * https://softwareengineering.stackexchange.com/questions/253421/running-time-of-simple-for-loops
 * for more info.
 */
public class Exercise6 {
  public static void main(String[] args) {
    StdOut.println(a(16));
    StdOut.println(b(16));
    StdOut.println(c(16));
  }

  // N + N/2 + N/4 + ... + 1 = 2N ~= O(N)
  private static int a(int N) {
    int sum = 0;
    for (int n = N; n > 0; n = n / 2) {
      for (int i = 0; i < n; i++) {
        sum++;
      }
    }

    return sum;
  }

  // // 1 + 2 + 4 + ... + N ~= O(N)
  private static int b(int N) {
    int sum = 0;
    for (int i = 1; i < N; i = i * 2) {
      for (int j = 0; j < i; j++) {
        sum++;
      }
    }

    return sum;
  }

  // O(N log N )
  private static int c(int N) {
    int sum = 0;
    for (int i = 1; i < N; i = i * 2)
      for (int j = 0; j < N; j++) {
        sum++;
      }

    return sum;
  }
}

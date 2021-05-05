package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

public class LongestRepeatingSubsequenceDP {
  public static int longestRepeatingSubsequence(String s1) {
    char[] a = s1.toCharArray();
    char[] b = s1.toCharArray();

    int[][] lrs = new int[a.length + 1][b.length + 1];

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {

        if (a[i - 1] == a[j - 1] && i != j) {
          lrs[i][j] = lrs[i - 1][j - 1] + 1;
        } else {

          lrs[i][j] = Math.max(lrs[i - 1][j], lrs[i][j - 1]);
        }
      }
    }

    StringBuilder result = new StringBuilder();

    int i = a.length, j = b.length;

    while (i >= 1 && j >= 1) {
      if (a[i - 1] == a[j - 1] && i != j) {
        result.append(a[i - 1]);
        i--;
        j--;
      } else if (lrs[i - 1][j] > lrs[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    StdOut.println("The longest repeating subsequence is: " + result.reverse().toString());

    return lrs[a.length][b.length];
  }

  public static void main(String[] args) {
    String s1 = "aabebcdd";
    StdOut.println(longestRepeatingSubsequence(s1) + " Expected 3");
  }
}

package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

public class LongestCommonSubstringDP {
  public static int longestCommonSubstring(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();
    int[][] lcs = new int[a.length + 1][b.length + 1];

    int max = 0;

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {

        if (a[i - 1] == b[j - 1]) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        } else {
          lcs[i][j] = 0;
        }

        if (lcs[i][j] > max) max = lcs[i][j];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    String a = "abcdxyz";
    String b = "xyzabcd";

    StdOut.println(longestCommonSubstring(a, b) + " Expected 4");
  }
}

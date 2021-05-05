package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

public class LongestCommonSubsequenceDP {

  public static int lcs(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();

    int[][] lcs = new int[a.length + 1][b.length + 1];

    for (int i = 1; i <= a.length; i++) {
      for (int j = 1; j <= b.length; j++) {
        if (a[i - 1] == b[j - 1]) {
          lcs[i][j] = lcs[i - 1][j - 1] + 1;
        } else {
          int aLCS = lcs[i - 1][j];
          int bLCS = lcs[i][j - 1];
          lcs[i][j] = Math.max(aLCS, bLCS);
        }
      }
    }

    return lcs[a.length][b.length];
  }

  public static void main(String[] args) {
    String a = "ABCDGH";
    String b = "AEDFHR";

    StdOut.println(lcs(a, b) + " Expected 3");

    StdOut.println(lcs("AGGTAB", "GXTXAYB") + " Expected 4");
  }
}

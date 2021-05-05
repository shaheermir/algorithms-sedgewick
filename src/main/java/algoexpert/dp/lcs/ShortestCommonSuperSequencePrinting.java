package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

public class ShortestCommonSuperSequencePrinting {

  public static String shortestCommonSuperSequence(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();

    int[][] dp = new int[a.length + 1][b.length + 1];

    for (int i = 0; i <= a.length; i++) {
      for (int j = 0; j <= b.length; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else if (a[i - 1] == b[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
        }
      }
    }
    util.MatrixUtil.printMatrix(dp);

    StringBuilder result = new StringBuilder("");

    int i = a.length;
    int j = b.length;

    while (i > 0 && j > 0) {
      if (a[i - 1] == b[j - 1]) {
        result.append(a[i - 1]);
        i--;
        j--;
      } else if (dp[i - 1][j] < dp[i][j - 1]) {
        result.append(a[i - 1]);
        i--;
      } else {
        result.append(b[j - 1]);
        j--;
      }
    }

    while (i > 0) result.append(a[--i]);
    while (j > 0) result.append(b[--j]);

    return result.reverse().toString();
  }

  public static void main(String[] args) {
    String s1 = "AGGTAB";
    String s2 = "GXTXAYB";
    StdOut.println(shortestCommonSuperSequence(s2, s1) + " Expected AGXGTXAYB");
  }
}

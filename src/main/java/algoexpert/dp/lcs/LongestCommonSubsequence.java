package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

public class LongestCommonSubsequence {

  public static int lcs(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();

    return lcs(a, b, a.length - 1, b.length - 1);
  }

  private static int lcs(char[] a, char[] b, int aIndex, int bIndex) {

    if (aIndex < 0 || bIndex < 0) return 0;

    if (a[aIndex] == b[bIndex]) return 1 + lcs(a, b, aIndex - 1, bIndex - 1);

    int aSubsequence = lcs(a, b, aIndex - 1, bIndex);
    int bSubsequence = lcs(a, b, aIndex, bIndex - 1);
    return Math.max(aSubsequence, bSubsequence);
  }

  public static void main(String[] args) {
    String a = "ABCDGH";
    String b = "AEDFHR";
    StdOut.println(lcs(a, b) + " Expected 3");
    StdOut.println(lcs("AGGTAB", "GXTXAYB") + " Expected 4");
  }
}

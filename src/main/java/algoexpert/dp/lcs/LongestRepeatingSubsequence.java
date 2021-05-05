package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

public class LongestRepeatingSubsequence {
  public static int longestRepeatingSubsequence(String s1) {
    return lrs(s1.toCharArray(), s1.toCharArray(), s1.length() - 1, s1.length() - 1);
  }

  // lrs is really just LCS with the restriction that  when both the characters are same, they
  // shouldn’t be on the same index in the two strings.
  private static int lrs(char[] a, char[] b, int aIndex, int bIndex) {
    if (aIndex < 0 || bIndex < 0) return 0;

    if (a[aIndex] == b[bIndex] && aIndex != bIndex) return 1 + lrs(a, b, aIndex - 1, bIndex - 1);

    return Math.max(lrs(a, b, aIndex - 1, bIndex), lrs(a, b, aIndex, bIndex - 1));
  }

  public static void main(String[] args) {
    String s1 = "aabebcdd";
    StdOut.println(longestRepeatingSubsequence(s1) + " Expected 3");
  }
}

package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

public class LongestCommonSubstring {

  public static int longestCommonSubstring(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();

    return longestCommonSubstring(a, b, a.length - 1, b.length - 1, 0);
  }

  private static int longestCommonSubstring(char[] a, char[] b, int aIndex, int bIndex, int count) {
    if (aIndex < 0 || bIndex < 0) return count;

    if (a[aIndex] == b[bIndex])
      return longestCommonSubstring(a, b, aIndex - 1, bIndex - 1, count + 1);

    // count gets reset to 0 since a n b at are no longer equal.
    int included = longestCommonSubstring(a, b, aIndex - 1, bIndex, 0);
    int skipped = longestCommonSubstring(a, b, aIndex, bIndex - 1, 0);

    // 3 options here
    return Math.max(count, Math.max(included, skipped));
  }

  public static void main(String[] args) {
    String a = "abcdxyz";
    String b = "xyzabcd";

    StdOut.println(longestCommonSubstring(a, b) + " Expected 4");
  }
}

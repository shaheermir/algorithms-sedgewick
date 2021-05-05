package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class LongestCommonSubsequenceMemo {

  public static int lcs(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();

    int cache[][] = new int[a.length][b.length];
    for (int i = 0; i < cache.length; i++) Arrays.fill(cache[i], -1);

    return lcs(a, b, a.length - 1, b.length - 1, cache);
  }

  private static int lcs(char[] a, char[] b, int aIndex, int bIndex, int[][] cache) {

    if (aIndex < 0 || bIndex < 0) return 0;

    if (cache[aIndex][bIndex] != -1) return cache[aIndex][bIndex];

    if (a[aIndex] == b[bIndex])
      return cache[aIndex][bIndex] = 1 + lcs(a, b, aIndex - 1, bIndex - 1, cache);

    int aSubsequence = lcs(a, b, aIndex - 1, bIndex, cache);
    int bSubsequence = lcs(a, b, aIndex, bIndex - 1, cache);
    return cache[aIndex][bIndex] = Math.max(aSubsequence, bSubsequence);
  }

  public static void main(String[] args) {
    String a = "ABCDGH";
    String b = "AEDFHR";

    StdOut.println(lcs(a, b) + " Expected 3");
    StdOut.println(lcs("AGGTAB", "GXTXAYB") + " Expected 4");
  }
}

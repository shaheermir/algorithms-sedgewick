package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

/**
 * Given two strings str1 and str2, the task is to find the length of the shortest string that has
 * both str1 and str2 as subsequences.
 *
 * <p>I use DP here, but we couldve also done the following: (a.length + b.length - LCS) Ive shown
 * it in SCS2.
 */
public class ShortestCommonSuperSequence {

  public static int shortestCommonSuperSequence(String s1, String s2) {
    char[] a = s1.toCharArray();
    char[] b = s2.toCharArray();

    return superSeq(a, b, a.length, b.length);
  }

  public static int superSeq(char[] a, char[] b, int aIndex, int bIndex) {
    if (aIndex == 0) return bIndex;
    if (bIndex == 0) return aIndex;

    if (a[aIndex - 1] == b[bIndex - 1]) return 1 + superSeq(a, b, aIndex - 1, bIndex - 1);

    return 1 + Math.min(superSeq(a, b, aIndex - 1, bIndex), superSeq(a, b, aIndex, bIndex - 1));
  }

  public static int SCSS2(String s1, String s2) {
    return s1.length() + s2.length() - LongestCommonSubsequence.lcs(s1, s2);
  }

  public static void main(String[] args) {
    String s1 = "AGGTAB";
    String s2 = "GXTXAYB";
    StdOut.println(shortestCommonSuperSequence(s1, s2) + " Expected AGXGTXAYB");
    StdOut.println(SCSS2(s1, s2) + " Expected 9");
  }
}

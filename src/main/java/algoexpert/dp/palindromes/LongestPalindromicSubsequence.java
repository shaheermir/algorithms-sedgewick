package algoexpert.dp.palindromes;

import edu.princeton.cs.algs4.StdOut;

/**
 * As another example, if the given sequence is “BBABCBCAB”, then the output should be 7 as
 * “BABCBAB” is the longest palindromic subsequence in it. “BBBBB” and “BBCBB” are also palindromic
 * subsequences of the given sequence, but not the longest ones.
 */
public class LongestPalindromicSubsequence {

  public static int longestPalindromicSubsequence(String s1) {
    String s2 = "";
    for (int i = s1.length() - 1; i >= 0; i--) s2 += s1.charAt(i);

    int lcsLength = algoexpert.dp.lcs.LongestCommonSubsequence.lcs(s1, s2);
    return lcsLength;
  }

  public static void main(String[] args) {

    StdOut.println(longestPalindromicSubsequence("BBABCBCAB") + " Expected 7.");
  }
}

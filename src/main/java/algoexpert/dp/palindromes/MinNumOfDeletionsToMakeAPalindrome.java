package algoexpert.dp.palindromes;

import edu.princeton.cs.algs4.StdOut;

/**
 * Minimum number of deletions to make a string palindrome Given a string of size ‘n’. The task is
 * to remove or delete minimum number of characters from the string so that the resultant string is
 * palindrome. Examples :
 *
 * <p>Input : aebcbda Output : 2 Remove characters 'e' and 'd' Resultant string will be 'abcba'
 * which is a palindromic string
 *
 * <p>Soln: Just find the longest palindromic seq. then do string.length - palindromic.length. Funyn
 * enough, this is also the soln if u wanted to find the min number of insertions needed to turn a
 * string into a palindrome.
 */
public class MinNumOfDeletionsToMakeAPalindrome {
  public static int minNumberToMakePalindrome(String s1) {
    String s2 = "";
    for (int i = s1.length() - 1; i >= 0; i--) s2 += s1.charAt(i);

    int longestPalindromicSeqLength =
        LongestPalindromicSubsequence.longestPalindromicSubsequence(s1);

    return s1.length() - longestPalindromicSeqLength;
  }

  public static void main(String[] args) {
    StdOut.println(minNumberToMakePalindrome("agbcba") + " Expected 1");
    StdOut.println(minNumberToMakePalindrome("aebcbda") + " Expected 1");
  }
}

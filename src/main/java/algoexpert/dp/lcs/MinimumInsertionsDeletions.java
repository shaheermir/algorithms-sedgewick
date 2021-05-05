package algoexpert.dp.lcs;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MinimumInsertionsDeletions {

  public static int[] numberOfInsertionsDeletionsFromAtoB(String s1, String s2) {
    int lcsLength = lcs(s1.toCharArray(), s2.toCharArray(), s1.length() - 1, s2.length() - 1);

    int deletions = s1.length() - lcsLength;
    int insertions = s2.length() - lcsLength;

    return new int[] {deletions, insertions};
  }

  private static int lcs(char[] a, char[] b, int aIndex, int bIndex) {
    if (aIndex < 0 || bIndex < 0) return 0;

    if (a[aIndex] == b[bIndex]) return 1 + lcs(a, b, aIndex - 1, bIndex - 1);

    return Math.max(lcs(a, b, aIndex - 1, bIndex), lcs(a, b, aIndex, bIndex - 1));
  }

  public static void main(String[] args) {
    String s1 = "hah";
    String s2 = "shaheer";

    StdOut.println(Arrays.toString(numberOfInsertionsDeletionsFromAtoB(s1, s2)));
  }
}

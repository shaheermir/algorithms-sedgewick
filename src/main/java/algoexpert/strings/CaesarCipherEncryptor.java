package algoexpert.strings;

import edu.princeton.cs.algs4.StdOut;

public class CaesarCipherEncryptor {
  public static String caesarCypherEncryptor(String str, int key) {
    String alphabets = "abcdefghijklmnopqrstuvwxyz";
    char[] ans = new char[str.length()];

    for (int i = 0; i < str.length(); i++) {
      int newLetterIndex = (alphabets.indexOf(str.charAt(i)) + key) % 26;
      ans[i] = alphabets.charAt(newLetterIndex);
    }

    return new String(ans);
  }

  public static void main(String[] args) {
    StdOut.println(caesarCypherEncryptor("xyz", 2));
  }
}

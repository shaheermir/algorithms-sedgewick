package playground;

import java.util.*;

public class PasswordCracker {
  public static String passwordCracker(List<String> passwords, String attempt) {

    List<Integer> indices = new ArrayList<>();

    Map<String, Integer> cache = new HashMap<String, Integer>();
    boolean cracked = passwordCracker(passwords, attempt, indices, cache);

    if (!cracked || attempt.equals("")) return "WRONG PASSWORD";

    StringBuilder result = new StringBuilder();
    Collections.reverse(indices);
    for (int i : indices) result.append(passwords.get(i)).append(" ");

    return result.toString().trim();
  }

  public static boolean passwordCracker(
      List<String> passwords, String attempt, List<Integer> indices, Map<String, Integer> cache) {
    if (attempt.length() == 0) return true;

    if (cache.containsKey(attempt)) {
      if (cache.get(attempt) != -1) {
        indices.add(cache.get(attempt));
        return true;
      } else {
        return false;
      }
    }

    for (int i = 0; i < passwords.size(); i++) {
      String password = passwords.get(i);
      if (attempt.startsWith(password)) {
        boolean temp =
            passwordCracker(passwords, attempt.substring(password.length()), indices, cache);
        if (temp) {
          cache.put(attempt, i);
          indices.add(i);
          return true;
        } else {
          cache.put(attempt, -1);
        }
      }
    }
    return false;
  }

  //  public static void main(String[] args) {
  //    String[] passwords = {"c", "aaaa", "aaaaaa", "aaaaa", "b"};
  //    String loginAttempt =
  //
  // "aaaaaaaaaaaaaacaaaaaaaaaaccaaaacaaaaacbaaaacccbccaaaaccccaaaaaaaaaaccbbbbaaaabcbaaaaaabaaaaacaaaaaacaaaaaaaaaaaaaaaaaaaabcaaaaaaaacaaaaaaaaaaaabaaaaaabaaaaaccaaaaaaaaaaaaaaaaaacaaaaabaaaaccbaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaacaaaaaaaaaaaaaaaaaccaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaabaaaabbcbaaaaaaaaaaaaaaaaaaaaaaaaaacaaaaaacaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaccaaaaaaaaaaaaaaaaabaaaaaaaaaaaaacaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaabbaaaaaabaaaaaaaaaaaaaaaaccaaaaaaaaaaaaaaaaaaabcccaaaaaaaabccaaaaacaaaaaaaaaaaaaaabaaaaaaaaaaaaaacaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaabaaaaaaaaaaaacbbaaaaaaaaaaacccccaaaabaaaabaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaabbbaaaaaaaaaaaaaaaaacaaaaaaaaaaaaaaaaaabcbaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaacaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaacccaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaacaaaaaaaaaaaaaaabcaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaabcaaaaaaaaaaaaaaacaaaaaaaaaaaaaaaaabaaaaacaaaaaaaaaaaaabbcaaaaaaaabaaaaabaaaaaabaaaaaaaaaacaaaaacaaaacaaaaaaaaaaaaacaaaaaaaaaacbbaaaaaaaaaaabaaaaaaaaaaaaaaaacbaaaaaaaaaacaaaaaaaaaaabbcaaaaaabbaaaaaaaaaaaaaabaaaaaaaaaabaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaccaaaaaaaaaaaaaaaaaaaaaaaaaaaacccaaaaabaaaacbaaaacaaaaaaaaaaaaaaaaaaaaabaaaaaaaaabaaaabcaaaaaacaaaabaaaabbaaaaaaaaaaaaaaaaaaaaaaaccaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaabaaaaaacaaaaaaaaaacbaaaacbaaaaacaaaaaaaaabaaaaaaaaaaaccaaaaaaaaaaaaaaabaaaaaaaaaaaaaaabcaaaaaaaaabbaaaaaaaaaaaccaaaaaaaaaaacbcbbcaaaaaccaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacaaaaaaaaaaaaabaaaaaaaaaaaaaabaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaabcaaaaacaaaaaaaaaacaaaaaaccaaaaacaaaaaaaaaabcbbaaaaaabaaaaaaaaaaaacaaaaaaaaaccaaaaaaaaaabaaaaaccaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaacbcaaaaaaaaaaaccbbaaaaaaaaaaaaaaaaabbaaaaaaaaaaacaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaabaaaaccaaaaaaaaabaaaaaaaaaaaacaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaccaaaaaaaaaaaaaaaaacccaaaaaaaaaabaaaaaaaaaaaaaaaaaacc";
  //
  //    String test = passwordCracker(Arrays.asList(passwords.clone()), loginAttempt);
  //
  //    StdOut.println(test);
  //    StdOut.println(test.length());
  //  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      int n = in.nextInt();
      String[] pass = new String[n];
      for (int pass_i = 0; pass_i < n; pass_i++) {
        pass[pass_i] = in.next();
      }
      String attempt = in.next();
      String result = passwordCracker(Arrays.asList(pass.clone()), attempt);
      System.out.println(result);
    }
    in.close();
  }
}

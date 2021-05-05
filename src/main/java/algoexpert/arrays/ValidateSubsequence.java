package algoexpert.arrays;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {
  public static boolean validateSubsequence(List<Integer> a, List<Integer> sequence) {

    int seqIndex = 0;
    for (int i = 0; i < a.size() && seqIndex < sequence.size(); i++) {
      if (a.get(i).equals(sequence.get(seqIndex))) seqIndex++;
    }

    return seqIndex == sequence.size();
  }

  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
    List<Integer> seq = Arrays.asList(1, 6, -1, 10);

    StdOut.println(validateSubsequence(a, seq) + " - expected true");
  }
}

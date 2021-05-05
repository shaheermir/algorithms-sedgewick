package algoexpert.arrays;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
  public static List<Integer> moveElementToEnd(List<Integer> a, int toMove) {

    int k = a.size();

    for (int i = 0; i < k; i++) {
      if (a.get(i) != toMove) continue;

      for (int j = a.size() - 1; j >= 0 && j > i; j--) {
        if (a.get(j) != toMove) {
          int temp = a.get(i);
          a.set(i, a.get(j));
          a.set(j, temp);
          k--;
          break;
        }
      }
    }

    return a;
  }

  public static List<Integer> moveElementToEndFaster(List<Integer> a, int toMove) {

    int i = 0;
    int j = a.size() - 1;

    while (i < j) {
      while (i < j && a.get(j) == toMove) j--;
      if (a.get(i) == toMove) swap(a, i, j);
      i++;
    }

    return a;
  }

  private static void swap(List<Integer> a, int i, int j) {
    int temp = a.get(i);
    a.set(i, a.get(j));
    a.set(j, temp);
  }

  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);

    StdOut.println(moveElementToEnd(a, 2));
    StdOut.println(moveElementToEndFaster(a, 2));
  }
}

package algoexpert.recursion;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {
  // Tip: You can use `element instanceof ArrayList` to check whether an item
  // is an array or an integer.
  public static int productSum(List<Object> a) {

    return generateProductSum(a, 1);
  }

  private static int generateProductSum(List<Object> a, int depth) {
    int sum = 0;

    for (Object o : a) {
      if (o instanceof List) {
        @SuppressWarnings("unchecked")
        ArrayList<Object> list = (ArrayList<Object>) o;
        sum += generateProductSum(list, depth + 1);
      } else {
        sum += (int) o;
      }
    }

    return depth * sum;
  }

  public static void main(String[] args) {
    //      [5, 2, [7, -1], 3, [6, [-13, 8], 4]]

    List<Object> a = new ArrayList<>();
    a.add(5);
    a.add(2);
    a.add(new ArrayList<>(Arrays.asList(7, -1)));
    a.add(3);

    List<Object> b = new ArrayList<>();
    b.add(6);
    b.add(new ArrayList<>(Arrays.asList(-13, 8)));
    b.add(4);

    a.add(b);

    StdOut.println(a);
    StdOut.println(productSum(a));
  }
}

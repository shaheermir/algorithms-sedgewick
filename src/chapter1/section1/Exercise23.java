package chapter1.section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import util.Utils;

import java.util.Arrays;

public class Exercise23 {

  // Arguments example:
  // 1.1.23.txt
  // +
  public static void main(String[] args) {
    String fileName = Utils.getDataFolderPath() + args[0];

    int[] whitelist = (new In(fileName)).readAllInts();
    char operation = args[1].charAt(0);

    StdOut.println(Arrays.toString(whitelist));
    StdOut.println(operation);

    if (operation != '-' && operation != '+') {
      throw new IllegalArgumentException("Operation needs to be - or +");
    }

    boolean searchForWhiteList = operation == '-';
    Arrays.sort(whitelist);

    while (!StdIn.isEmpty()) {
      int key = StdIn.readInt();
      int index = Exercise22.recursiveBinarySearch(whitelist, key);

      if (index != -1 && searchForWhiteList) {
        StdOut.println("Number in whitelist: " + key);
      }

      if (index == -1 && !searchForWhiteList) {
        StdOut.println("Number not in whitelist: " + key);
      }
    }
  }
}

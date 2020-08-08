package chapter1.section4;

import edu.princeton.cs.algs4.*;

/** To run -> java Intro data/1Kints.txt */
public class Intro {

  public static void main(String[] args) {
    In in = new In(args[0]);
    int[] a = in.readAllInts();

    Stopwatch s1 = new Stopwatch();
    StdOut.println("ThreeSum: " + ThreeSum.count(a));
    StdOut.println("e1: " + s1.elapsedTime());

    Stopwatch s2 = new Stopwatch();
    StdOut.println("\nThreeSumFast: " + ThreeSumFast.count(a));
    StdOut.println("e2: " + s2.elapsedTime());
  }
}

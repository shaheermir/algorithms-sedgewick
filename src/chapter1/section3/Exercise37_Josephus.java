package chapter1.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise37_Josephus {
  public static void main(String[] args) {
    int numberOfPeople = 4;
    int skip = 2;
    StdOut.println("Number Of People: " + numberOfPeople);
    StdOut.println("Skip: " + skip);
    StdOut.println("\nOrder of Elimination");
    josephus(numberOfPeople, skip);
  }

  /**
   * O(n * (skip - 1))
   *
   * @param numberOfPeople - Number of people in the game.
   * @param skip - Number of people to skip before kill.
   */
  private static void josephus(int numberOfPeople, int skip) {
    Queue<Integer> q = new Queue<>();
    for (int i = 0; i < numberOfPeople; i++) q.enqueue(i);

    while (numberOfPeople > 0) {
      for (int i = 1; i < skip; i++) {

        q.enqueue(q.dequeue());
      }

      StdOut.println(q.dequeue());
      numberOfPeople--;
    }
  }
}

package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickFindUF {
  private int[] id; // access to component id (site indexed)
  private int count; // number of components

  public QuickFindUF(int N) {
    this.count = N;
    this.id = new int[N];
    for (int i = 0; i < N; i++) id[i] = i;
  }

  public int count() {
    return count;
  }

  /**
   * O(1)
   *
   * @param p - the node / site being searched for.
   * @return the component / group ID.
   */
  public int find(int p) {
    return id[p];
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * "Unites" nodes / sites into a single group to represent connections. N^2 array accesses. O(N)
   *
   * @param p - site / node to connect.
   * @param q - site / node to connect.
   */
  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    if (pID == qID) return;

    for (int i = 0; i < id.length; i++) {
      if (id[i] == pID) id[i] = qID;
    }
    count--;
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    StdOut.println(N);
    QuickFindUF uf = new QuickFindUF(N);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();

      if (uf.connected(p, q)) continue;

      uf.union(p, q);
      StdOut.println(p + " " + q);
    }
    StdOut.println(uf.count() + " components");
  }
}

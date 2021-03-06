package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QuickUnionUF {
  private int[] id; // access to component id (site indexed)
  private int count; // number of components

  public QuickUnionUF(int N) {
    this.count = N;
    this.id = new int[N];
    for (int i = 0; i < N; i++) id[i] = i;
  }

  public int count() {
    return count;
  }

  /**
   * Worst Case: Tree Height. O(N)
   *
   * @param p - the node / site being searched for.
   * @return the component / group ID.
   */
  public int find(int p) {
    // follow links to find root node
    while (p != id[p]) p = id[p];
    return p;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * Constructs a tree to represent connections amongst nodes. Worst Case: Tree Height. (O(2N))
   *
   * @param p - site / node to connect.
   * @param q - site / node to connect.
   */
  public void union(int p, int q) {
    int pParentID = find(p);
    int qParentID = find(q);

    if (pParentID == qParentID) return;

    id[pParentID] = qParentID;
    count--;
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    StdOut.println(N);
    QuickUnionUF uf = new QuickUnionUF(N);
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

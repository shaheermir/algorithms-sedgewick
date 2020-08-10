package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {
  private int[] id; // parent link (site indexed)
  private int[] sz; // size of group for roots (site indexed)
  private int count; // number of groups / sites

  public WeightedQuickUnionUF(int N) {
    this.count = N;

    this.id = new int[N];
    for (int i = 0; i < N; i++) id[i] = i;

    this.sz = new int[N];
    for (int i = 0; i < N; i++) sz[i] = 1;
  }

  public int count() {
    return count;
  }

  /**
   * O(N)
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
   * Constructs a tree to represent connections amongst nodes. O(N) For certain inputs, this can
   * change to O(N^2) due to the way find is setup.
   *
   * @param p - site / node to connect.
   * @param q - site / node to connect.
   */
  public void union(int p, int q) {
    int pParentID = find(p);
    int qParentID = find(q);

    if (pParentID == qParentID) return;

    if (sz[pParentID] < sz[qParentID]) {
      id[pParentID] = qParentID;
      sz[qParentID] = sz[qParentID] + sz[pParentID];
    } else {
      id[qParentID] = pParentID;
      sz[pParentID] = sz[pParentID] + sz[qParentID];
    }

    count--;
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    StdOut.println(N);
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
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

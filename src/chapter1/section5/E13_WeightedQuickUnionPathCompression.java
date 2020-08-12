package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E13_WeightedQuickUnionPathCompression {
  private int[] id; // parent link (site indexed)
  private int[] sz; // size of group for roots (site indexed)
  private int count; // number of groups / sites

  public E13_WeightedQuickUnionPathCompression(int N) {
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
   * Tree Height: O(log N)
   *
   * @param p - the node / site being searched for.
   * @return the component / group ID.
   */
  public int find(int p) {
    int root = p;
    while (root != id[root]) {
      root = id[root];
    }

    while (p != root) {
      int next = id[p];
      id[p] = root;
      p = next;
    }

    return root;
  }

  public int find2(int p) {
    if (p == id[p]) return p;

    return id[p] = find2(id[p]);
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /**
   * Constructs a tree to represent connections amongst nodes. Tree Height: O(log N)
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
    E13_WeightedQuickUnionPathCompression uf = new E13_WeightedQuickUnionPathCompression(N);
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

package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class E12_QuickUnionPathCompression {
  private int[] id;
  private int count;

  public E12_QuickUnionPathCompression(int N) {
    this.count = N;
    this.id = new int[N];
    for (int i = 0; i < N; i++) id[i] = i;
  }

  public int count() {
    return count;
  }

  //  amortized constant time
  public int find(int p) {
    int root = p;
    while (root != id[root]) root = id[root];

    // path compression. Go back up the tree and make everything point to root.
    while (p != root) {
      int next = id[p];
      id[p] = root;
      p = next;
    }

    return root;
  }

  // recursive find: amortized O(Log N)
  public int find2(int p) {
    if (p == id[p]) return p;

    return id[p] = find2(id[p]);
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  // amortized O(log N)
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
    E12_QuickUnionPathCompression uf = new E12_QuickUnionPathCompression(N);
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

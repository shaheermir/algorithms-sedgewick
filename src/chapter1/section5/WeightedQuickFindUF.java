package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Find is still O(N) compared to QuickFind, but the number of parent updates have been reduced. For
 * example, with quick find, we were arbitrarily merging 2 groups regardless of size. Imagine
 * merging groupA of size 10 with groupB of size 2.
 *
 * <p>It is obviously more performant to update the two nodes in groupB to match the nodes in
 * groupA, then it is to update the 10 nodes in groupA to match the 2 nodes in groupB.
 */
public class WeightedQuickFindUF {
  private int[] id;
  private int count;
  private int[] sz;

  public WeightedQuickFindUF(int N) {
    this.count = N;

    this.id = new int[N];
    for (int i = 0; i < N; i++) id[i] = i;

    this.sz = new int[N];
    for (int i = 0; i < N; i++) sz[i] = 1;
  }

  public int count() {
    return count;
  }

  public int find(int p) {
    return id[p];
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);
    if (pID == qID) return;

    int smallerParent;
    int biggerParent;

    if (sz[pID] < sz[qID]) {
      smallerParent = pID;
      biggerParent = qID;
    } else {
      smallerParent = qID;
      biggerParent = pID;
    }

    for (int i = 0; i < id.length; i++) {
      if (id[i] == smallerParent) id[i] = biggerParent;
    }
    sz[biggerParent] += sz[smallerParent];
    count--;
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    StdOut.println(N);
    WeightedQuickFindUF uf = new WeightedQuickFindUF(N);
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

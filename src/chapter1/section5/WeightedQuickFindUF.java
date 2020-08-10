package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

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

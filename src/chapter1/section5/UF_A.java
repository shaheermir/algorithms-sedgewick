package chapter1.section5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class UF_A {
  private int[] id; // access to component id (site indexed)
  private int count; // number of components

  public UF_A(int N) {
    this.count = N;
    this.id = new int[N];
    for (int i = 0; i < N; i++) id[i] = i;
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

    for (int i = 0; i < id.length; i++) {
      if (id[i] == pID) id[i] = qID;
    }
    count--;
    StdOut.println(Arrays.toString(id));
  }

  public static void main(String[] args) {
    int N = StdIn.readInt();
    StdOut.println(N);
    UF_A uf = new UF_A(N);
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

package chapter2.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.StdOut;

public class MultiwayMerge {
  private static void merge(In[] streams) {
    int N = streams.length;
    IndexMinPQ<String> pq = new IndexMinPQ<>(N);

    // take first element from each stream, insert it into PQ
    for (int i = 0; i < N; i++) {
      if (!streams[i].isEmpty()) pq.insert(i, streams[i].readString());
    }

    while (!pq.isEmpty()) {
      StdOut.print(pq.minKey() + " ");
      int i = pq.delMin();
      if (!streams[i].isEmpty()) pq.insert(i, streams[i].readString());
    }
  }

  public static void main(String[] args) {
    int N = args.length;
    In[] streams = new In[N];
    for (int i = 0; i < N; i++) streams[i] = new In(args[i]);
    merge(streams);
  }
}

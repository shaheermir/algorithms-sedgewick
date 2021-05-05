package chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise31 {
    /**
     * @param N - Number of equally spaced points to be drawn.
     * @param p - Probability that a pair of points gets a line drawn between them.
     */
    private static void draw(int N, double p) {
        StdDraw.setCanvasSize(1024, 1024);
        StdDraw.setPenRadius(0.015);
        StdDraw.setScale(-1, 1);

        double[][] d = new double[N][2];
        for (int i = 0; i < N; i++) {
            d[i][0] = Math.cos(2 * Math.PI * i / N);
            d[i][1] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(d[i][0], d[i][1]);
        }

        StdDraw.setPenRadius();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
                }
            }
        }

    }

    public static void main(String[] args) {
        draw(5, 1);
    }
}

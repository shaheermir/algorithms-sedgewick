package chapter1.section2;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

public class Exercise10 {

    public static class VisualCounter {
        int maxNumberOfOperations;
        int operationsSoFar = 0;

        int maxValue;
        int value = 0;

        public VisualCounter(int N, int max) {
            this.maxNumberOfOperations = N;
            this.maxValue = max;

            StdDraw.setCanvasSize(1024, 512);
            StdDraw.setPenRadius(.015);
            StdDraw.setXscale(0, N + 1);
            StdDraw.setYscale(-max - 3, max + 3);
        }

        public void increment() {
            if (operationsSoFar < maxNumberOfOperations && value < maxValue) {
                this.value++;
                this.operationsSoFar++;
            }
            StdDraw.setPenColor(Color.GREEN);
            plotCounter();
        }

        public void decremnet() {
            if (operationsSoFar < maxNumberOfOperations) {
                this.value--;
                this.operationsSoFar++;
            }
            StdDraw.setPenColor(Color.RED);
            plotCounter();
        }


        private void plotCounter() {
            StdDraw.point(operationsSoFar, value);
        }
    }

    public static void main(String[] args) {
        VisualCounter counter = new VisualCounter(10, 5);
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment(); // redundant
        counter.increment(); // redundant
        counter.decremnet();
        counter.decremnet();
    }
}

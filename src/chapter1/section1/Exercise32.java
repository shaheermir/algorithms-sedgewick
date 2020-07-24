package chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdStats;

import java.util.ArrayList;
import java.util.List;

public class Exercise32 {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double left = Double.parseDouble(args[1]);
        double right = Double.parseDouble(args[2]);

        List<Double> numbers = new ArrayList<>();
        int numberIndex = 3;
        try {
            while (args[numberIndex] != null) {
                numbers.add(Double.parseDouble(args[numberIndex]));
                numberIndex++;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
        }

        double[] numbersArray = new double[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            numbersArray[i] = numbers.get(i);
        }
        histogram(N, left, right, numbersArray);
    }

    /**
     * @param N       - Number of equally spaced intervals between min and max.
     * @param left    - min
     * @param right   - max
     * @param numbers - values for the histogram
     */
    public static void histogram(int N, double left, double right, double[] numbers) {
        double interval = (right - left) / N;
        int[] numbersInInterval = new int[N];
        computeHistogramValues(N, left, right, numbers, numbersInInterval);

        int maxCount = StdStats.max(numbersInInterval);

        double minX = left - 1;
        double maxX = right + 1;
        double minY = -2;
        double maxY = maxCount + 2;

        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setXscale(minX, maxX);
        StdDraw.setYscale(minY, maxY);

        double middleX = minX + (maxX - minX) / 2;
        double middleY = minY + (maxY - minY) / 2;

        StdDraw.text(middleX, maxY - 0.5, "Numbers in intervals"); // title
        StdDraw.text(minX + 0.25, middleY, "Numbers", 90); // y-axis
        StdDraw.text(middleX, -1.2, "Intervals"); // x-axis

        // X labels
        for (int x = 0; x < N; x++) {
            double minValue = left + (interval * x);
            double maxValue = minValue + interval - 0.01;
            String intervalDescription = String.format("[%.2f - %.2f]", minValue, maxValue);
            StdDraw.text(left + (x + 0.5) * interval, -0.25, intervalDescription);
        }
        // Y labels
        for (int y = 0; y < maxY; y++) {
            StdDraw.text(minX + 0.7, y, String.valueOf(y));
        }

        for (int i = 0; i < N; i++) {
            double x = left + (i + 0.5) * interval;
            double y = numbersInInterval[i] / 2.0;
            double halfWidth = interval / 3.0;
            double halfHeight = numbersInInterval[i] / 2.0;
            StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
        }
    }

    private static void computeHistogramValues(int N, double left, double right, double[] numbers, int[] numbersInInterval) {
        double interval = (right - left) / N;
        int intervalIndex;

        for (int i = 0; i < numbers.length; i++) {
            intervalIndex = 0;
            for (double j = left; j <= right && intervalIndex < N; j = j + intervalIndex) {
                if (numbers[i] >= j && numbers[i] <= j + interval) {
                    numbersInInterval[intervalIndex]++;
                }
                intervalIndex++;
            }
        }
    }

}

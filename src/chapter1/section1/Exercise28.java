package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise28 {
    public static void main(String[] args) {
        int key = 1;
        int[] nums = {1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 9};
        Arrays.sort(nums);

        int[] uniqueNums = removeDuplicatesFromSortedArray(nums);

        StdOut.println(Arrays.toString(uniqueNums));

        Exercise22.recursiveBinarySearch(nums, key);
    }

    public static int[] removeDuplicatesFromSortedArray(int[] array) {
        int[] temp = new int[array.length];
        int uniqueCounter = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int currentElement = array[i];
            int nextElement = array[i + 1];
            if (currentElement != nextElement)
                temp[uniqueCounter++] = currentElement;
        }

        // our loop doesnt cover last index, so we have to take it into account here.
        temp[uniqueCounter++] = array[array.length - 1];

        // temp array has unique values, but it has extra empty indices initialized to 0.
        int[] uniqueArray = new int[uniqueCounter];
        for (int i = 0; i < uniqueArray.length; i++) {
            uniqueArray[i] = temp[i];
        }

        return uniqueArray;
    }
}

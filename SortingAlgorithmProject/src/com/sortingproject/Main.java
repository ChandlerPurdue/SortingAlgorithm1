package com.sortingproject;

public class Main {
    public static void main(String[] args) {
        // Generate data sets
        int[] smallData = DataGenerator.generateSmallData();
        int[] mediumData = DataGenerator.generateMediumData();
        int[] largeData = DataGenerator.generateLargeData();

        // Time the execution of sorting the small data set
        long startTime = System.nanoTime();
        MergeSort.mergeSort(smallData, 0, smallData.length - 1);
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Small data set sort time: " + elapsedTime + " nanoseconds");

        // Repeat the timing for medium and large data sets
        startTime = System.nanoTime();
        MergeSort.mergeSort(mediumData, 0, mediumData.length - 1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Medium data set sort time: " + elapsedTime + " nanoseconds");

        startTime = System.nanoTime();
        MergeSort.mergeSort(largeData, 0, largeData.length - 1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Large data set sort time: " + elapsedTime + " nanoseconds");

        // Now run the algorithm on your manually created array
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        // Print the original unsorted array
        System.out.println("\nOriginal array:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        // Time the execution of sorting the manually created array
        startTime = System.nanoTime();
        MergeSort.mergeSort(array, 0, array.length - 1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("\n\nManually created array sort time: " + elapsedTime + " nanoseconds");

        // Print the sorted array
        System.out.println("\nSorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

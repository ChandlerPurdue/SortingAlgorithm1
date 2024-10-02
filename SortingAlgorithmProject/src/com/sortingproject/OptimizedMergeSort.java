package com.sortingproject;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class OptimizedMergeSort extends RecursiveAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int[] arr;
    private final int beg, end;
    private final int[] tempArr;

    private static final int THRESHOLD = 5; // Threshold for switching to insertion sort

    public OptimizedMergeSort(int[] arr, int beg, int end, int[] tempArr) {
        this.arr = arr;
        this.beg = beg;
        this.end = end;
        this.tempArr = tempArr;
    }

    @Override
    protected void compute() {
        if (isSorted(arr, beg, end)) {
            return;
        }

        if (end - beg <= THRESHOLD) {
            // Use insertion sort for small subarrays
            insertionSort(arr, beg, end);
            return;
        }

        if (beg < end) {
            int mid = (beg + end) / 2;

            OptimizedMergeSort leftTask = new OptimizedMergeSort(arr, beg, mid, tempArr);
            OptimizedMergeSort rightTask = new OptimizedMergeSort(arr, mid + 1, end, tempArr);

            invokeAll(leftTask, rightTask); // Run tasks in parallel

            merge(arr, beg, mid, end, tempArr);
        }
    }

    // Merge function to combine two halves using a single temporary array
    private static void merge(int[] arr, int beg, int mid, int end, int[] tempArr) {
        System.arraycopy(arr, beg, tempArr, beg, end - beg + 1);

        int i = beg, j = mid + 1, k = beg;

        while (i <= mid && j <= end) {
            if (tempArr[i] <= tempArr[j]) {
                arr[k] = tempArr[i];
                i++;
            } else {
                arr[k] = tempArr[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of the left half if any
        while (i <= mid) {
            arr[k] = tempArr[i];
            i++;
            k++;
        }

        // Remaining elements of right half are already in place
    }

    // Insertion sort for small subarrays
    private static void insertionSort(int[] arr, int beg, int end) {
        for (int i = beg + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= beg && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Check if the array is already sorted
    private static boolean isSorted(int[] arr, int beg, int end) {
        for (int i = beg + 1; i <= end; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Main method to test the optimized merge sort
    public static void parallelMergeSort(int[] arr) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] tempArr = new int[arr.length];
        pool.invoke(new OptimizedMergeSort(arr, 0, arr.length - 1, tempArr));
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Given Array");
        printArray(arr);

        parallelMergeSort(arr);

        System.out.println("\nSorted Array");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

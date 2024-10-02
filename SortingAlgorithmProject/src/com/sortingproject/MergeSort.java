package com.sortingproject;
public class MergeSort {
   // Recursive mergeSort function
   public static void mergeSort(int[] arr, int beg, int end) {
       if (beg < end) {
           int mid = (beg + end) / 2;
           // Recursively divide the array into two halves
           mergeSort(arr, beg, mid);
           mergeSort(arr, mid + 1, end);
           // Merge the two halves together
           merge(arr, beg, mid, end);
       }
   }
   // Merge function to combine two halves
   private static void merge(int[] arr, int beg, int mid, int end) {
       int n1 = mid - beg + 1;
       int n2 = end - mid;
       // Temporary arrays
       int[] leftArr = new int[n1];
       int[] rightArr = new int[n2];
       // Copy data into temporary arrays
       for (int i = 0; i < n1; i++) {
           leftArr[i] = arr[beg + i];
       }
       for (int j = 0; j < n2; j++) {
           rightArr[j] = arr[mid + 1 + j];
       }
       int i = 0, j = 0;
       int k = beg;
       // Merge the arrays back together
       while (i < n1 && j < n2) {
           if (leftArr[i] <= rightArr[j]) {
               arr[k] = leftArr[i];
               i++;
           } else {
               arr[k] = rightArr[j];
               j++;
           }
           k++;
       }
       // Copy remaining elements of leftArr[] if any
       while (i < n1) {
           arr[k] = leftArr[i];
           i++;
           k++;
       }
       // Copy remaining elements of rightArr[] if any
       while (j < n2) {
           arr[k] = rightArr[j];
           j++;
           k++;
       }
   }
}

package com.sortingproject;

import java.util.Random;

public class DataGenerator {

    // Generates a small data set (10 elements)
    public static int[] generateSmallData() {
        Random rand = new Random();
        int[] smallData = new int[10];
        for (int i = 0; i < smallData.length; i++) {
            smallData[i] = rand.nextInt(1000);  // Random numbers between 0 and 999
        }
        return smallData;
    }

    // Generates a medium data set (1,000 elements)
    public static int[] generateMediumData() {
        Random rand = new Random();
        int[] mediumData = new int[1000];
        for (int i = 0; i < mediumData.length; i++) {
            mediumData[i] = rand.nextInt(1000);  // Random numbers between 0 and 999
        }
        return mediumData;
    }

    // Generates a large data set (10,000 elements)
    public static int[] generateLargeData() {
        Random rand = new Random();
        int[] largeData = new int[10000];
        for (int i = 0; i < largeData.length; i++) {
            largeData[i] = rand.nextInt(1000);  // Random numbers between 0 and 999
        }
        return largeData;
    }
}
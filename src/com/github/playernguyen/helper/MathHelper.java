package com.github.playernguyen.helper;

public class MathHelper {

    /**
     * Generate a random in a range [min, max].
     *
     * @param min the lowest value to retrieve randomly value
     * @param max the highest value to retrieve randomly
     * @return a random value from range [min, max]
     */
    public static double boundRandom(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    /**
     * Generate a random list with value in range [min, max].
     *
     * @param size a size of list
     * @param min  a min possible value in list
     * @param max  a max possible value in list
     * @return a random list with size value in range [min, max].
     */
    public static int[] generateRandomList(int size, int min, int max) {
        int[] k = new int[size];
        for (int i = 0; i < size; i++) {
            k[i] = (int) MathHelper.boundRandom(min, max);
        }
        return k;
    }
}

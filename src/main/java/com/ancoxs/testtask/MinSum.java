package main.java.com.ancoxs.testtask;

import java.util.Arrays;

public class MinSum {

    private MinSum() {
    }

    private static int arraySum(int[] array) {
        return Arrays.stream(array).sum();
    }

    public static int arrayMinSum(int[] array, int moves) {
        checkContstraints(array, moves);
        while (moves > 0) {
            replaceMaxElement(array);
            moves--;
        }
        return arraySum(array);
    }

    private static int[] replaceMaxElement(int[] array){
        Arrays.sort(array);
        array[array.length-1] = array[array.length-1] / 2 + ((array[array.length-1] % 2 == 0) ? 0 : 1);
        return array;
    }

    private static void checkContstraints(int[] array, int moves) throws IllegalArgumentException {
        if (array.length <= 0 || moves <= 0) {
            throw new IllegalArgumentException("Given array should have at least one element and the amount of moves should be greater then 0");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0)
                throw new IllegalArgumentException("Given array should contain only integers greater then 0");
        }
    }

}

package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {    	
    	if (array == null || array.length == 0) {
            System.out.println("Array is empty");
        } else {
            int[] result = new int[array.length];
            System.arraycopy(array, 0, result, 1, array.length - 1);
            result[0] = array[array.length - 1];
            System.arraycopy(result, 0, array, 0, array.length);
        }
    }

    static void cycleSwap(int[] array, int shift) {
    	 if (array == null || array.length == 0) {
             System.out.println("Array is empty");
         } else {
             int[] result = new int[array.length];
             System.arraycopy(array, 0, result, shift, array.length - shift);
             System.out.println(Arrays.toString(result));
             System.arraycopy(array, array.length - shift, result, 0, shift);
             System.arraycopy(result, 0, array, 0, array.length);
         }
     
    }
}

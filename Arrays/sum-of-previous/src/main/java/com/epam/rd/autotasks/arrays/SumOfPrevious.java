package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfPrevious {

    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};

        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }

    public static boolean[] getSumCheckArray(int[] array){

    	boolean[] bArray = new boolean[array.length];
        bArray[0] = false;
        bArray[1] = false;
        int sum = 0;
        for (int i = 0; i < array.length-2; i++) {
			sum = array[i]+array[i+1];
			if(sum == array[i+2]) {
				bArray[i+2] = true;
			}else {
				bArray[i+2] = false;
			}
		}
        return bArray;
    }
}

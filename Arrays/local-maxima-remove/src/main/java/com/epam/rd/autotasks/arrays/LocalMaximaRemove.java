package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
    	int min = Integer.MIN_VALUE;    	
    	int[] arrayX = Arrays.copyOf(array, array.length); 
        for (int i = 0; i <= array.length-1; i++) {	
        	if(i==0 && array[i]>array[i+1]) {        		   
        		arrayX[i] = min;
    		}        	
			if(i>0 && i<array.length-1 && array[i]>array[i-1] && array[i]>array[i+1]) {
				arrayX[i] = min;
			}			
			if(i==array.length-1 && array[array.length-1]>array[array.length-2]) {
	    		arrayX[i] = min;
			}			
		}
        
        int j = 0;
        for (int i = 0; i < arrayX.length; i++) {
			if(arrayX[i]!=min) {
				arrayX[j] = arrayX[i];
				j++;
			}
		}
        
        int[] result = Arrays.copyOf(arrayX, j);        
        return result;
    }
}

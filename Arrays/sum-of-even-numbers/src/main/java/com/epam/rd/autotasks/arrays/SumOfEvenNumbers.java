package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    @SuppressWarnings("null")
	public static int sum(int[] array){
    	int sum = 0;
    	try {
    		
        	if(array != null || (array.length != 0)) {
        		for (int i = 0; i < array.length; i++) {
            		if(array[i]%2==0) {
            			sum +=array[i];
            		}			
        		}
        	}    
		} catch (NullPointerException e) {
			System.out.println(e.getLocalizedMessage());
		}
    		
    	return sum;
    }
}

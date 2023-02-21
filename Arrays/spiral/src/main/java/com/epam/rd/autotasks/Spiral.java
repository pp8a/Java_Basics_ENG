package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {
    	int[][] spiral = new int [rows][columns];     	
		int target = ((2 * rows) - 3) + ((2 * columns)-1);
		int temp = target+1;
		if(rows == 1) {
			int j = 0;
			int i = 1;
			while(j < columns) {
				spiral[0][j] = i;
				j++;
				i++;				
			}
		}else {
			int last = 0;
	    	for (int i = 0; i < spiral.length; i++) {
	    	    for (int j = 0; j < spiral[i].length; j++) {    	    	
	    	    	if(i==0) {
	    	    		spiral[i][j] = j + 1;
	    	    		if(j==columns-1) last = j + 1;
	    	    	}
	    	    	if(i>0) {
	    	    		if(j==0) {
	    	    			spiral[i][j] = target+j;    	    			
	    	    		} 
	    	    		if(j==columns-1){
	    	    			last += 1;
	    	    			spiral[i][j] = last;
	    	    			target--;
	    	    		} 
	    	    	}
	    	    	if(i==rows-1 && j!=columns-1) {
	    	    		spiral[i][j] = target-j;
	    	    	}
	    	    	//System.out.print(String.format("%4s", spiral[i][j]));
	    	    }
	    	    //System.out.println();
	    	}
		}
		
    	int y = 1;
    	int x = 1;
    	
    	while(temp < rows*columns) {
    		//right
    		while(spiral[y][x+1] == 0) {
    			spiral[y][x] = temp;
    			temp++;
    			x++;
    		}
    		//down
    		while(spiral[y+1][x] == 0) {
    			spiral[y][x] = temp;
    			temp++;
    			y++;
    		}
    		//left
    		while(spiral[y][x-1] == 0) {
    			spiral[y][x] = temp;
    			temp++;
    			x--;
    		}
    		//up
    		while(spiral[y-1][x] == 0) {
    			spiral[y][x] = temp;
    			temp++;
    			y--;
    		}    		
    	}
    	
    	
    	for (int i = 0; i < spiral.length; i++) {
    	    for (int j = 0; j < spiral[i].length; j++) {
    	    	if(spiral[i][j]==0) spiral[i][j]=temp;
    	        System.out.print(String.format("%4s", spiral[i][j]));
    	    }
    	    System.out.println();
    	}	
    	
        return spiral;
    }
}

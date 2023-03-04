package com.epam.rd.autotasks;

public class CarouselRun {

	private int [] carousel;
	private int i = 0;
	
	public CarouselRun(int[] carousel) {
		super();
		this.carousel = carousel;
	}

	public int next() {		
		
    	if(isFinished()) return -1;
    	
    	while (carousel[i %=carousel.length] == 0) {
            i++;
        }
    	return carousel[i++]--; 
    }

    public boolean isFinished() {
    	for (int element : carousel) {
    		if(element > 0)
			return false;
		}
        return true;
    }

}

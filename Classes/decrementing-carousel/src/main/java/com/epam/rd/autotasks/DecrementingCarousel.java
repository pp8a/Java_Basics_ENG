package com.epam.rd.autotasks;

import java.util.Arrays;

public class DecrementingCarousel {
	private int capacity;
	private int[] carousel;  
	private boolean runCarousel = false;
	private int i = 0;	
		
    public DecrementingCarousel(int capacity) {
    	this.capacity = capacity;
    	carousel = new int [capacity];
    }

    public boolean addElement(int element){
    	if(element > 0 && i < capacity && !runCarousel) {
    		carousel[i++] = element;    		
    		return true;
    	}
    	
    	return false;
    }

    public CarouselRun run(){
    	if(!runCarousel) {
    		runCarousel = true;
    		return new CarouselRun(carousel);
    	}
    	
		return null;
    }

	public int[] getCarousel() {
		return carousel;
	}
}

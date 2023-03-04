package com.epam.rd.autotasks;

public class DecrementingCarousel {
	protected int capacity;
	protected int[] carousel;  
	protected boolean runCarousel = false;
	protected int i = 0;		
		
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
}

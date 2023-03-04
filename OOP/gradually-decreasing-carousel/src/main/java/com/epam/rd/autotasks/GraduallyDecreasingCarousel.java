package com.epam.rd.autotasks;

public class GraduallyDecreasingCarousel extends DecrementingCarousel{
    public GraduallyDecreasingCarousel(final int capacity) {
        super(capacity);
    }

	@Override
	public CarouselRun run() {
		if(!runCarousel) {
    		runCarousel = true;
    		return new CarouselRun(carousel) {
    			int decrement = 0;
				@Override
				public int next() {
					int before;
					if(isFinished()) {						
						return -1;
					}	
					
					int y = i;
					while (carousel[i %=carousel.length] <= 0) {						
						i++;
			        }					
					
					if(y>i) {
						decrement++;						
					}
					
					before = carousel[i];
					carousel[i] = carousel[i++]-decrement;
					
			    	return before; 
				}
    			
    		};
    	}
		return super.run();
	}
    
    
}

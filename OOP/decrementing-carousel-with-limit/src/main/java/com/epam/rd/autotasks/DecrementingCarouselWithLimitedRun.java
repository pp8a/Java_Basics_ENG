package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
	private int actionLimit;
	
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }

	@Override
	public CarouselRun run() {
		if(!runCarousel) {
    		runCarousel = true;
    		return new CarouselRun(carousel) {
    			
				@Override
				public int next() {					
					
					if(isFinished()) return -1;
			    	
			    	while (carousel[i %=carousel.length] == 0) {
			            i++;
			        }
			    	
			    	actionLimit-=1;			    	
			    	
			    	return carousel[i++]--;
				}

				@Override
				public boolean isFinished() {	
					if(actionLimit!=0) {
						for (int element : carousel) {
				    		if(element > 0)
							return false;
						}	
					}									
			        return true;
				}
    			
    		};
		}
		return super.run();
	}
    
    
}

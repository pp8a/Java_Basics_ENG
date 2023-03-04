package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {	
	
    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

	@Override
	public CarouselRun run() {
		if(!runCarousel) {
    		runCarousel = true;
    		return new CarouselRun(carousel) {
    			
				@Override
				public int next() {					
					int before;
					if(isFinished()) {						
						return -1;
					}	
					
					while (carousel[i %=carousel.length] == 0) {						
						i++;
			        }					
						
					before = carousel[i];
					carousel[i] = carousel[i++]-- / 2;
					
			    	return before; 
//					return super.next();
				}

				@Override
				public boolean isFinished() {
					// TODO Auto-generated method stub
					return super.isFinished();
				}
    			
    		};
    	}
		return super.run();
	}
    
    
}

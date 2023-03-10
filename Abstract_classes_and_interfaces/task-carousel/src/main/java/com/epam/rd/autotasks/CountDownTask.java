package com.epam.rd.autotasks;

public class CountDownTask implements Task{
	private int value;
	private boolean isFineshed;
    public CountDownTask(int value) {    	 
    	if(value < 0) value = 0;
        this.value = value;
        this.isFineshed = false;
        if(value == 0) this.isFineshed = true;
    }
    
    public int getValue() {
		return value;
	}
    
	@Override
    public void execute() {
		value--;
		if(value <= 0) {
			value = 0;
			isFineshed = true;  
		}		      
    }

    @Override
    public boolean isFinished() {
        return isFineshed;
    }
}

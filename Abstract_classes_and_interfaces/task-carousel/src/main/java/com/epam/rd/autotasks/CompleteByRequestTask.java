package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
	private boolean isFinished;
	private boolean complete;
	
    public CompleteByRequestTask() {
		super();
		this.isFinished = false;
		this.complete = false;
	}

	@Override
    public void execute() {
        if(complete) isFinished = true;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
        complete = true;
    }
}

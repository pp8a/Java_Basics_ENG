package com.epam.rd.autotasks;

public class TaskCarousel {	
	private Task[] tasks;
    private int index = 0;

    public TaskCarousel(int capacity) {
        tasks = new Task[capacity];        
    }

    public boolean addTask(Task task) {
        if(task == null || isFull() || task.isFinished()){
            return false;
        }
        
        for (int i = 0; i < tasks.length; i++){
            if(tasks[i] == null){
                tasks[i] = task;
                return true;
            }
        }
        return true;
    }

    public boolean execute() {
    	
        while (!isEmpty()) {
            if(index == tasks.length) index = 0;
            if (tasks[index] != null) {
                tasks[index].execute();
                if (tasks[index].isFinished()) tasks[index] = null;                
                index++;
                return true;
            }             
            index++;
        }
        return false;
    }

    public boolean isFull() {
        for (Task task : tasks){
            if(task == null) return false;            
        }
        return true;
    }

    public boolean isEmpty() {
        for (Task task : tasks){
            if(task != null) return false;
        }
        return true;
    }
}

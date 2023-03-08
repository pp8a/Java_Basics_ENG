package com.epam.rd.autotasks.sprintplanning;

import java.util.Arrays;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
	private int capacity;
	private int ticketsLimit;
	
	private Ticket[] tickets;
	private int totalEstimate;
	
	private int i;
	
    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory==null || userStory.isCompleted()) return false;        
              
        for (UserStory dependent:userStory.getDependencies()){
            if (dependent.isCompleted() == false){
                boolean contains = false;
                for (int y = 0; y < i; y++){                	
                    if (tickets[y].equals(dependent)){                    	
                        contains = true;
                    }
                }
                if (contains == false){
                    return false;
                }
            }
        }
        
        if(ticketsLimit == 0  ) return false; 
        
        if (capacity - userStory.getEstimate() < 0) return false;
        
        tickets[i++] = userStory;
        ticketsLimit--;
        
        capacity -= userStory.getEstimate();        
        totalEstimate += userStory.getEstimate();
       
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport == null || bugReport.isCompleted()) return false;
        
        if(ticketsLimit == 0) {
        	return false;
        }  
 
        if (capacity - bugReport.getEstimate() < 0) return false;        

        tickets[i++] = bugReport;
        totalEstimate += bugReport.getEstimate();

        ticketsLimit--;
        capacity -= bugReport.getEstimate();        
        
        return true;
    }

    public Ticket[] getTickets() {
    	int countLength = 0;
        for (Ticket value : tickets) {
            if (value != null) {
                countLength++;
            }
        }
       
        return Arrays.copyOf(tickets, countLength);
    }

    public int getTotalEstimate() {    	
        return totalEstimate;
    }
}

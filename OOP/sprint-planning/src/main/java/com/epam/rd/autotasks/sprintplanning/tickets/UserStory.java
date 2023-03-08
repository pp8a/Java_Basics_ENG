package com.epam.rd.autotasks.sprintplanning.tickets;

import java.util.Arrays;

public class UserStory extends Ticket {
	private UserStory[] stories;
    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.stories = dependsOn;
    }

    @Override
    public void complete() {
    	isCompleted = true;
    	for (UserStory userStory : stories) {
			if(!userStory.isCompleted) {
				isCompleted = false;				
			}
		}
    }

    public UserStory[] getDependencies() {    	
       return Arrays.copyOf(stories, stories.length);
    }

	@Override
	public String toString() {
		return "[US "+ getId() +"] "+ getName();
	}
}

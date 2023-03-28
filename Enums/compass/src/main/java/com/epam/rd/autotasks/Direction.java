package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
    	while(degrees >= 360) degrees = degrees - 360;
        while(degrees < 0) degrees = 360 + degrees;
        
    	Direction [] directions = Direction.values();
    	for (Direction direction : directions) {
			if(direction.degrees == degrees) {
				return direction;
			}
		}
    	return null;
    }

    public static Direction closestToDegrees(int degrees) {
    	while(degrees >= 360) degrees = degrees - 360;
        while(degrees < 0) degrees = 360 + degrees;
        
    	int value = Integer.MAX_VALUE;
    	Direction direction = null;
    	for (Direction directions : Direction.values()) {
			if(directions.degrees == degrees) return directions;
			int x = Math.abs(directions.degrees - degrees);
			if(x < value) {
				value = x;
				direction = directions;
			}
		}
    	
    	return direction;
    }

    public Direction opposite() {
        return ofDegrees(degrees+180);
    }

    public int differenceDegreesTo(Direction direction) {
    	int difference = Math.abs(direction.degrees - degrees);
    	if(difference > 180) return Math.abs(360-direction.degrees);    	
    	return difference;
    }
}

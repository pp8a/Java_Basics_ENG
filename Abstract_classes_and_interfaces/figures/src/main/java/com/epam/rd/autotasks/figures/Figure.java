package com.epam.rd.autotasks.figures;

import java.util.function.BiFunction;

abstract class Figure{

    public abstract double area();

    public abstract String pointsToString();

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();
    
    public static double side(Point x, Point y) {		
		BiFunction<Point, Point, Double> f = (u, t) -> Math.sqrt(Math.pow((x.getX()-y.getX()), 2)+Math.pow((x.getY()-y.getY()), 2));		
		return f.apply(x, y);
	}
}

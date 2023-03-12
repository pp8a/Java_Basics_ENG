package com.epam.rd.autotasks.figures;

import java.util.function.Supplier;

class Triangle extends Figure{		
	private Point a;
	private Point b;
	private Point c;	
	    
	public Triangle(Point a, Point b, Point c) {
    	super();
    	this.a = a;
    	this.b = b;
    	this.c = c;			
    }    
    
	@Override
    public double area() {
		Supplier<Double> square = ()-> {				
			double p =((side(a, b)+side(b, c)+side(c, a))/2);				
			return Math.sqrt(p*(p-side(a, b))*(p-side(b, c))*(p-side(c, a)));
		};
		return square.get();
    }

	@Override
	public String pointsToString() {
		return "("+a.getX()+","+a.getY()+")("+b.getX()+","+b.getY()+")("+c.getX()+","+c.getY()+")";		
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public Point leftmostPoint() {
		Point[] points = new Point[] {a, b, c};
		Point left = points[0];
		for (Point point : points) {
			if(left.getX() > point.getX()) left = point;
		}
		return left;
	}
    
}

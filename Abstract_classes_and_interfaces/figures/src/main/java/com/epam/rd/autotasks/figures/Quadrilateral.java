package com.epam.rd.autotasks.figures;


import java.util.function.Supplier;



class Quadrilateral extends Figure{
	private Point a;
	private Point b;
	private Point c;
	private Point d;
	
	public Quadrilateral(Point a, Point b, Point c, Point d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;		
	}
	
	@Override
	public double area() {
		Supplier<Double> squareA = ()-> {				
			double p =((side(a, b)+side(b, c)+side(c, a))/2);				
			return Math.sqrt(p*(p-side(a, b))*(p-side(b, c))*(p-side(c, a)));
		};
		Supplier<Double> squareB = ()-> {				
			double p =((side(a, d)+side(d, c)+side(c, a))/2);				
			return Math.sqrt(p*(p-side(a, d))*(p-side(d, c))*(p-side(c, a)));
		};
				
		return squareA.get()+squareB.get();
	}
	
	@Override
	public String pointsToString() {
		return "("+a.getX()+","+a.getY()+")("+b.getX()+","+b.getY()+")("+c.getX()+","+c.getY()+")("+d.getX()+","+d.getY()+")";	
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public Point leftmostPoint() {
		Point[] points = new Point[] {a, b, c, d};
		Point left = points[0];
		for (Point point : points) {
			if(left.getX() > point.getX()) left = point;
		}
		return left;
	}
		
}

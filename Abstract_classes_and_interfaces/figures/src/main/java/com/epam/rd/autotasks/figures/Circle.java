package com.epam.rd.autotasks.figures;

class Circle extends Figure{
	private Point c;
	private double r;	
	
	public Circle(Point c, double r) {
		super();
		this.c = c;
		this.r = r;
	}

	@Override
	public double area() {		
		return Math.PI*r*r;
	}

	@Override
	public String pointsToString() {
		return "("+c.getX()+","+c.getY()+")";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle[("+c.getX()+","+c.getY()+")"+r+"]";
	}

	@Override
	public Point leftmostPoint() {
		return new Point((c.getX()-r), c.getY());
	}
	
	

}

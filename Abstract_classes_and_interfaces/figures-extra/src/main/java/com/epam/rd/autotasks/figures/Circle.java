package com.epam.rd.autotasks.figures;

class Circle extends Figure{
	private Point center;
	private double radius;
	
	public Circle(Point center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
		
		if(center == null || radius <=0) throw new IllegalArgumentException();		
	}
	
	

	@Override
	public Point centroid() {
		// TODO Auto-generated method stub
		return new Point(center.getX(), center.getY());
	}

	@Override
	public boolean isTheSame(Figure figure) {
		final double DELTA = 1e-15;
		if(figure instanceof Circle){
			Circle circle = (Circle) figure;
			
			if(Math.abs(center.getX() - circle.center.getX()) <= DELTA &&
            		(Math.abs(center.getY() - circle.center.getY()) <= DELTA) &&
            		(Math.abs(radius - circle.radius) <= DELTA)) return true;			
		}
		return false;
	}

}

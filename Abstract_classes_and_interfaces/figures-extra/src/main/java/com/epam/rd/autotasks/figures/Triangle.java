package com.epam.rd.autotasks.figures;

import java.util.function.BiFunction;

class Triangle extends Figure{
	private Point a;
	private Point b;
	private Point c;
	
	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		if(a == null || b == null || c == null) 
			throw new IllegalArgumentException("Point is null");
		if ((a.getX()-b.getX())*(c.getY()-b.getY())-(a.getY()-b.getY())*(c.getX()-b.getX())==0) 
			throw new IllegalArgumentException("Triangle is degenerative");
	}

	@Override
	public Point centroid() {
		BiFunction<Double, Double, Point> f = ((t, u) -> new Point(t, u));        
        return f.apply(((a.getX()+b.getX()+c.getX())/3), ((a.getY()+b.getY()+c.getY())/3));
	}

	@Override
	public boolean isTheSame(Figure figure) {
		// TODO Auto-generated method stub
		return false;
	}

}

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
		if(a == null || b == null || c == null || d == null) 
			throw new IllegalArgumentException("Point is null");		
		
		if(areaA() <=0 || areaB() <= 0) throw new IllegalArgumentException("Area is null");
		
		if (wherePoint(a, b, c) * (-1) == wherePoint(a, b, d) || (wherePoint(b, c, d) * (-1) == wherePoint(b, c, a))) {
			throw new IllegalArgumentException();
	    }
	}
	
	 public int wherePoint(Point a, Point b, Point myPoint) {
         double s;
         s = (b.getX() - a.getX()) * (myPoint.getY() - a.getY()) - (b.getY() - a.getY()) * (myPoint.getX() - a.getX());
         if (s > 0)  return 1;
         else if (s < 0)  return -1;
         else return 0;
     }

	@Override
	public Point centroid() {
		Point[] points = {a,b,c,d,a};		 
		return new Point(Ax(points), Ay(points));
	}
	
	public double areaA() {
		Supplier<Double> squareA = ()-> {
			return 0.5 * Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY()));
		};	
		return squareA.get();
	}
	
	public double areaB() {		
		Supplier<Double> squareB = ()-> {				
			return 0.5 * Math.abs((d.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (d.getY() - a.getY()));
		};	
		return squareB.get();
	}
	
	public double area(Point[] points) {
        double sum = 0;
        for (int i = 0; i < points.length - 1; i++) {
            sum += (points[i].getX() * points[i + 1].getY() - points[i + 1].getX() * points[i].getY());
        }
        return sum/2;     
    }
			
	public double Ax(Point[] points) {
		double aX = 0;		
	    for (int i = 0; i < points.length-1; i++)
	    {
	        aX += (points[i].getX() + points[i + 1].getX()) * (points[i].getX() * points[i + 1].getY() - points[i + 1].getX() * points[i].getY());
	    }
		return aX/(6*area(points));		
	}
	
	public double Ay(Point[] points) {
		double aY = 0;		
	    for (int i = 0; i < points.length-1; i++)
	    {
	        aY += (points[i].getY() + points[i + 1].getY()) * (points[i].getX() * points[i + 1].getY() - points[i + 1].getX() * points[i].getY());	        
	    }
		return aY/(6*area(points));		
	}
	
	@Override
	public boolean isTheSame(Figure figure) {      
        final double DELTA = 1e-15;
		if(figure instanceof Quadrilateral){
            Quadrilateral other = (Quadrilateral) figure;
            if (other.a != a){ // вершины
	            if (a.getX()==other.b.getX()||
	            		b.getX()==other.c.getX()||
	            		c.getX()==other.d.getX()||
	            		d.getX()==other.a.getX()) return true;
	            if (a.getX()==other.b.getX()||
	            		b.getX()==other.a.getX()||
	            		c.getX()==other.d.getX()||
	            		d.getX()==other.c.getX()) return true;
	            if (a.getX()==other.c.getX()||
	            		b.getX()==other.b.getX()||
	            		c.getX()==other.a.getX()||
	            		d.getX()==other.d.getX()) return true;
            }
            if(other.a.getX() != a.getX() || 
            		other.b.getX() != b.getX() || 
            		other.c.getX() != c.getX() || 
            		other.d.getX() != d.getX()) return false;
            if(Math.abs(a.getX() - other.a.getX()) <= DELTA ||
            		(Math.abs(b.getX() - other.b.getX()) <= DELTA) ||
            		(Math.abs(c.getX() - other.c.getX()) <= DELTA) ||
            		(Math.abs(d.getX() - other.d.getX()) <= DELTA)) return true;
        }
        
		return false;
	}		
}

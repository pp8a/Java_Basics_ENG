package com.epam.rd.autotasks.triangle;

import java.util.function.BiFunction;
import java.util.function.Supplier;

class Triangle {
	Point a;
	Point b;
	Point c;
	double sideA;
	double sideB;
	double sideC;
	
    public Triangle(Point a, Point b, Point c) {
    	super();
    	this.a = a;
    	this.b = b;
    	this.c = c;	
		this.sideA = side(a, b);
		this.sideB = side(b, c);
		this.sideC = side(c, a);
		
		if ((sideA + sideC) <= sideB || (sideA + sideB) <= sideC || (sideB + sideC) <= sideA)
            throw new IllegalArgumentException();
    }    

    public double area() {
    	Supplier<Double> square = ()-> {				
			double p =((sideA+sideB+sideC)/2);				
			return Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
		};
		return square.get();
    }

    public Point centroid(){    	
        BiFunction<Double, Double, Point> f = ((t, u) -> new Point(t, u));
        
        return f.apply(((a.getX()+b.getX()+c.getX())/3), ((a.getY()+b.getY()+c.getY())/3));
    }    
       
    public static double side(Point x, Point y) {		
		BiFunction<Point, Point, Double> f = (u, t) -> Math.sqrt(Math.pow((x.getX()-y.getX()), 2)+Math.pow((x.getY()-y.getY()), 2));	
		
		return f.apply(x, y);
	}

}

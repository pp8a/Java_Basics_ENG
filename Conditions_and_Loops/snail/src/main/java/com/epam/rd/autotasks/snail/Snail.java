package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        try (//Write a program that reads a,b and h (line by lyne in this order) and prints
		        //the number of days for which the snail reach the top of the tree.
		        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
		Scanner sc = new Scanner(System.in)) {
			int a, b , h;
			System.out.println("a = ");
			a = sc.nextInt();
			System.out.println("b = ");
			b = sc.nextInt();
			System.out.println("h = ");
			h = sc.nextInt();    	
			
			int i = 0;
			int j = 0;
			int day = 0;
			
			if(a<=b && a < h) {
				System.out.println("Impossible");
			}else {
				do {    		
					j = i + a;
					i = j - b;
					day++;
					
				}while(h>j);
				  	
				System.out.println(day);
			}
		}
    	
    }
}

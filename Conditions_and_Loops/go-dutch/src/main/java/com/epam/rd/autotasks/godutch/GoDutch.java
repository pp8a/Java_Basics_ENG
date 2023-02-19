package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			int totalBill;
			totalBill = sc.nextInt();
			if(totalBill < 0) {
				System.out.println("Bill total amount cannot be negative");
			}        
      
			int numberOfFreinds;
			numberOfFreinds = sc.nextInt();
			if(numberOfFreinds <= 0) {
				System.out.println("Number of friends cannot be negative or zero");
			}
			
			if(!(totalBill < 0) && !(numberOfFreinds <= 0)) {
				totalBill = totalBill + (totalBill*10/100);
			    int partTopay = totalBill/numberOfFreinds;
			    System.out.println(partTopay);
			}
		}
    }
}

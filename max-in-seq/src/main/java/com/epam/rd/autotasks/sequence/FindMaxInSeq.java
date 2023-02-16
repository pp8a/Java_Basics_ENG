package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
    	int max = Integer.MIN_VALUE;
    	try (Scanner sc = new Scanner(System.in)) {
			int input = -1;
			while (sc.hasNextInt()) {			
				input = sc.nextInt();
				if(input == 0) break;
				if(input > max) {
					max = input;
				}
			}
		}
		return max;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        System.out.println(max());
    }
}

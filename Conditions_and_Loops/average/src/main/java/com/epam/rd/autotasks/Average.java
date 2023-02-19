package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			int input = -1;
			 int count = 0;
			 int sum = 0;
			 while (scanner.hasNextInt()) {
				input = scanner.nextInt();
				if(input == 0) break;
				sum+=input;
				count++;
			 }
			 
			 System.out.println(sum/count);
		}

    }

}
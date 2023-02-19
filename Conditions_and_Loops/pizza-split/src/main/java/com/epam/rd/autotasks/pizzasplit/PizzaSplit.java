package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        try (//Write a program, reading number of people and number of pieces per pizza and then
		        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder
		Scanner sc = new Scanner(System.in)) {
			int nPeople = sc.nextInt();
			int nPieces = sc.nextInt();
			int nPizza = 1;
			for (int i = nPizza; ; i++) {
				int number = nPieces*i;
				if(number%nPeople == 0) {
					nPizza = number/nPieces;
					break;
				}
			}
			
			System.out.println(nPizza);
		}
    }
}

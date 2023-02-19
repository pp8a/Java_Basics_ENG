package com.epam.rd.autotasks.meetastranger;

import java.util.Scanner;

public class MeetAStranger {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			String str = sc.nextLine();
			System.out.println("Hello, "+str);
		}
    }
}

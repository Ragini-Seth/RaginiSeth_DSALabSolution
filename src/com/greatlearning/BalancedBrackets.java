package com.greatlearning;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
	private static Scanner sc = new Scanner(System.in);
	
	public static boolean isBalanced(String brackets) {

		int len = brackets.length();
		// Base Condition -> for odd numbered brackets
		if (len <= 0 || len % 2 != 0) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < len; i++) {
			char currentChar = brackets.charAt(i);

			// For all incoming opening brackets, just push it.
			if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
				stack.push(currentChar);
			} else if (!stack.isEmpty()) {
				if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
					char top = stack.peek();
					boolean isParenthisis = top == '(' && currentChar == ')';
					boolean isFlower = top == '{' && currentChar == '}';
					boolean isSquare = top == '[' && currentChar == ']';

					if (isParenthisis || isFlower || isSquare) {
						stack.pop();
					} else {
						// Can be any opening bracket
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}
	
	private static void operationRequested(int optionValue) {
		switch(optionValue) {
			case 0:
				System.out.println("Exited successfully");
				sc.close();
				break;
			case 1:
				boolean result = isBalanced(sc.next());
				if(result) {
					System.out.println("The entered String has Balanced Brackets");
				} else {
					System.out.println("The entered Strings do not contain Balanced Brackets");	
				}
				getUserInputOptions();
				break;
		}
	}
	
	private static void getUserInputOptions() {
		System.out.println("\n");
		System.out.println("-----------------------------------------------");
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Please provide sample input");
		System.out.println("2. press 0 to exit");
		System.out.println("-----------------------------------------------");
		
		operationRequested(sc.nextInt());
	}

	public static void main(String[] args) {
		//Get the user input option for operation they want to perform
		getUserInputOptions();
	}

}
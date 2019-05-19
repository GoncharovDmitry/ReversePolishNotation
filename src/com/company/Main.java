package com.company;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Double> stack = new Stack<>();

        Scanner sc = new Scanner(System.in);
        String input;

        input = sc.nextLine();
        for (String symbol : input.split("\\s+")) {
            switch (symbol) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "/":
                    double divider = stack.pop();
                    stack.push(stack.pop() / divider);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "^":
                    double index = stack.pop();
                    stack.push(Math.pow(stack.pop(), index));
                    break;
                default:
                    try {
                        stack.push(Double.parseDouble(symbol));
                    } catch (Exception e) {
                        System.out.println("Введено некорректное значение!");
                        return;
                    }
            }
        }

        double result = stack.pop();
        System.out.println(stack.isEmpty() ? result : "Некорректная запись");

        sc.close();
    }
}
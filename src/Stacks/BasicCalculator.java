package Stacks;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        // Testa några enkla uttryck
        String expression1 = "3+2*2";
        System.out.println("Result of " + expression1 + ": " + calculator.calculate(expression1));

        String expression2 = " 3/2 ";
        System.out.println("Result of " + expression2 + ": " + calculator.calculate(expression2));

        String expression3 = " 3+5 / 2 ";
        System.out.println("Result of " + expression3 + ": " + calculator.calculate(expression3));

        String expression4 = " 14-3/2 ";
        System.out.println("Result of " + expression4 + ": " + calculator.calculate(expression4));
    }
}

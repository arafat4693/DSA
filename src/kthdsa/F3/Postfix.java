package kthdsa.F3;

import java.util.Stack;

public class Postfix {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (isOperand(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                int rightOperand = stack.pop();
                int leftOperand = stack.pop();
                int result = performOperation(leftOperand, rightOperand, token);
                stack.push(result);
            }
        }

        // The final result will be on the top of the stack
        return stack.pop();
    }

    private static boolean isOperand(String token) {
        // Check if the first character of the token is a digit
        return Character.isDigit(token.charAt(0));
    }

    private static boolean isOperator(String token) {
        // Check if the token is an operator
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int performOperation(int leftOperand, int rightOperand, String operator) {
        switch (operator) {
            case "+":
                return leftOperand + rightOperand;
            case "-":
                return leftOperand - rightOperand;
            case "*":
                return leftOperand * rightOperand;
            case "/":
                return leftOperand / rightOperand;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String postfixExpression = "12 6 + 3 /";
        int result = evaluatePostfix(postfixExpression);
        System.out.println("Result: " + result); // Output: 6
    }
}

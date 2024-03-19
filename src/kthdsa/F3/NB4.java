package kthdsa.F3;

import java.util.EmptyStackException;
import java.util.Stack;

public class NB4 {
    private static final String OPEN = "({[";
    private static final String CLOSE = ")}]";

    public static boolean isBalanced(String expression){
        Stack<Character> parenthesis = new Stack<>();
        try {
            for(int i = 0; i < expression.length(); i++){
                char current = expression.charAt(i);
                if(isOpen(current)) parenthesis.push(current);
                if(isClose(current)){
                    char top = parenthesis.pop();
                    if((top == '(' && current != ')') || (top == '{' && current != '}') || (top == '[' && current != ']')) {
                        return false;
                    }
                }
            }
        }catch (EmptyStackException ex){
            return false;
        }

        return parenthesis.empty();
    }

    private static boolean isOpen(char ch){
        return OPEN.indexOf(ch) != -1;
    }

    private static boolean isClose(char ch){
        return CLOSE.indexOf(ch) != -1;
    }
}

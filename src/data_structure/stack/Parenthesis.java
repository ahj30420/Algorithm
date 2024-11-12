package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalCnt = Integer.parseInt(reader.readLine());

        for(int i = 0; i < totalCnt; i++){
            if(isVPS(reader.readLine())){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }

        reader.close();
    }

    private static boolean isVPS(String input) {
        Stack<Character> stack = new Stack<>();
        char[] parenthesisList = input.toCharArray();

        for(int i = 0; i < parenthesisList.length; i++){
            if(parenthesisList[i] == '('){
                stack.push(parenthesisList[i]);
            } else{
                if(stack.isEmpty()){
                    return false;
                } else{
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
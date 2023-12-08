package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis_String {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for(int i = 0; i < T; i++){
           if(isVPS(reader.readLine())){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        reader.close();
    }

    private static boolean isVPS(String line) {
        Stack<Character> stack = new Stack<>();
        char[] ps = line.toCharArray();

        for(int i = 0; i < ps.length; i++){
            if(ps[i] == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            else{
                stack.push(ps[i]);
            }
        }

        return stack.isEmpty();
    }

}

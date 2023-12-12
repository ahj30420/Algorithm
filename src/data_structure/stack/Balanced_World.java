package data_structure.stack;

import java.io.*;

//균형잡힌 세상
public class Balanced_World {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String content = reader.readLine();

        while(!content.equals(".")){
            isBalanced(content, sb);
            content = reader.readLine();
        }

        System.out.println(sb.toString());
        reader.close();

    }

    private static void isBalanced(String content, StringBuilder sb) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        String result = "yes\n";
        for(int i = 0; i < content.length(); i++){
            char target = content.charAt(i);
            if(target == '(' || target == '['){
                stack.add(target);
            }
            else if(target == ')' || target == ']'){
                if(stack.isEmpty()){
                    result = "no\n";
                    break;
                }
                else if((stack.peek() == '(' && target == ')') || (stack.peek() == '[' && target == ']')){
                    stack.pop();
                }
                else{
                    result = "no\n";
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            result = "no\n";
        }

        sb.append(result);
    }
}

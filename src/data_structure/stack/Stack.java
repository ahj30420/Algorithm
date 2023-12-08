package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack {
    public static void main(String args[]) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        int count = Integer.parseInt(reader.readLine());

        for(int i = 0; i < count; i++){
            executeStack(stack,reader.readLine());
        }
        reader.close();
    }

    private static void executeStack(java.util.Stack stack, String line) {
        if(line.contains(" ")){
            int index = line.lastIndexOf(" ");
            stack.push(Integer.parseInt(line.substring(index+1)));
        }

        else{
            switch(line){
                case "top":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(stack.peek());
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    if(stack.isEmpty()){
                        System.out.println(1);
                    }
                    else{
                        System.out.println(0);
                    }
                    break;

                case "pop":
                    if(stack.isEmpty()){
                        System.out.println(-1);
                    }
                    else{
                        System.out.println(stack.pop());
                    }
                    break;

            }
        }

    }
}

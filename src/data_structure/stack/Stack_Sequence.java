package data_structure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Stack_Sequence {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(reader.readLine()));
        }

        for(int i = 1; i <= n; i++){
            stack.push(i);
            builder.append("+\n");

            while(!stack.isEmpty() && stack.peek().equals(list.get(index))){
                stack.pop();
                builder.append("-\n");
                index++;
            }
        }

        if(stack.isEmpty()){
            System.out.println(builder.toString());
        }

        else{
            System.out.println("NO");
        }

    }
}

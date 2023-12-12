package data_structure.stack;

import java.io.*;

//제로
public class Zero {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(reader.readLine());
        int sum = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for(int i = 0; i < k; i++){
            int target = Integer.parseInt(reader.readLine());

            if(target != 0){
                sum += stack.push(target);
            }
            else{
                sum -= stack.pop();
            }
        }

        System.out.println(sum);
        reader.close();

    }
}

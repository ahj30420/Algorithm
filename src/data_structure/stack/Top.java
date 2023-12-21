package data_structure.stack;

import java.util.Stack;
import java.io.*;
import java.util.StringTokenizer;

//탑
public class Top {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty()){
                if(arr[i] < arr[stack.peek()]){
                    result[i] = stack.peek()+1;
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }

        for(int num : result){
            System.out.print(num + " ");
        }

        reader.close();

    }
}

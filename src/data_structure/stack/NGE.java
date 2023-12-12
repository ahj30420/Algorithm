package data_structure.stack;

import java.io.*;
import java.util.*;

//오큰수
public class NGE {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] result = findNGE(arr);

        for (int rs : result) {
            System.out.print(rs + " ");
        }

        reader.close();

    }

    private static int[] findNGE(int[] arr) {
        int[] result = new int[arr.length];
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }
        return result;
    }
}

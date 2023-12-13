package data_structure.queue;

import java.io.*;
import java.util.*;

//queuestack
public class QueueStack {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            int elem = Integer.parseInt(tokenizer.nextToken());
            if(arr[i] == 0){
                deque.addLast(elem);
            }
        }

        int m = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < m; i++){
            deque.addFirst(Integer.parseInt(tokenizer.nextToken()));
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb.toString());
        reader.close();

    }
}

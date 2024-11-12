package data_structure.queue;

import java.util.*;
import java.io.*;

public class Josephus {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }

        output.append("<");
        int count = 0;
        while(!queue.isEmpty()){
            count++;
            int value = queue.poll();

            if(count == K){
                if(queue.isEmpty()){
                    output.append(value).append(">");
                } else{
                    output.append(value).append(", ");
                }
                count = 0;
            } else{
                queue.offer(value);
            }
        }

        System.out.println(output.toString());
    }
}

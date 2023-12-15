package data_structure.priorityQueue;

import java.util.*;
import java.io.*;

//N번째 큰 수
public class NLargetNumber {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++){
                priorityQueue.add(Integer.parseInt(tokenizer.nextToken()));
            }
        }

        int count = 0;
        while(count <= n-2){
            priorityQueue.poll();
            count++;
        }

        System.out.println(priorityQueue.poll());
        reader.close();

    }
}

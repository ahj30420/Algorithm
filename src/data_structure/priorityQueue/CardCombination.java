package data_structure.priorityQueue;

import java.util.*;
import java.io.*;

//카드 합체 놀이
public class CardCombination {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            priorityQueue.add(Long.parseLong(tokenizer.nextToken()));
        }

        for(int i = 0; i < m; i++){
            long combination = priorityQueue.poll() + priorityQueue.poll();
            priorityQueue.add(combination);
            priorityQueue.add(combination);
        }

        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += priorityQueue.poll();
        }

        System.out.println(sum);
        reader.close();

    }
}

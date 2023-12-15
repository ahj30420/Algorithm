package data_structure.priorityQueue;

import java.util.*;
import java.io.*;

//국회의원 선거
public class ParliamentaryElection {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int target = 0;

        for(int i = 0; i < n; i++){
            if(i == 0){
                target = Integer.parseInt(reader.readLine());
            }
            else {
                int votes = Integer.parseInt(reader.readLine());
                priorityQueue.add(votes);
            }
        }

        int count = 0;
        while(!priorityQueue.isEmpty() && target <= priorityQueue.peek()){
            int MaxVotes = priorityQueue.poll();
            priorityQueue.add(MaxVotes-1);
            target++;
            count++;
        }

        System.out.println(count);
        reader.close();

    }
}

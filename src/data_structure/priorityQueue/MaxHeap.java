package data_structure.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//최대 힙
public class MaxHeap {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            int content = Integer.parseInt(reader.readLine());
            executeMaxPriorityQueue(pq,sb,content);
        }

        reader.close();
        System.out.println(sb.toString());

    }

    private static void executeMaxPriorityQueue(PriorityQueue<Integer> pq, StringBuilder sb, int content){
        if(content == 0){
            if(pq.isEmpty()){
                sb.append("0\n");
            }
            else{
                sb.append(pq.poll() + "\n");
            }
        }

        else{
            pq.offer(content);
        }
    }

}

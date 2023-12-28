package data_structure.priorityQueue;

import java.util.*;
import java.io.*;

//가운데를 말해요
public class Middle {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            int elem = Integer.parseInt(reader.readLine());

            if(maxHeap.isEmpty() || maxHeap.peek() >= elem){
                maxHeap.offer(elem);
            } else{
                minHeap.offer(elem);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append('\n');

        }

        System.out.println(sb);
        reader.close();
    }
}

package data_structure.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//최소 힙
public class MinHeap {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            int content = Integer.parseInt(reader.readLine());
            executeMinPriorityQueue(pq,sb,content);
        }

        reader.close();
        System.out.println(sb.toString());

    }

    private static void executeMinPriorityQueue(PriorityQueue pq, StringBuilder sb, int content) {
        if(content == 0){
            if(pq.isEmpty()){
                sb.append("0\n");
            }
            else{
                sb.append(pq.poll()+"\n");
            }
        }

        else{
            pq.add(content);
        }
    }
}

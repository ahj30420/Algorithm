package data_structure.queue;

import java.io.*;
import java.util.*;

//트럭
public class Truck {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        java.util.Queue<Integer> truckQueue = new LinkedList<>();
        java.util.Queue<Integer> bridgeQueue = new LinkedList<>();
        int n = Integer.parseInt(tokenizer.nextToken());
        int w = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        for(int i = 0;  i < n; i++){
            int elem = Integer.parseInt(tokenizer.nextToken());
            truckQueue.add(elem);
        }

        for(int i = 0; i < w; i++){
            bridgeQueue.add(0);
        }

        int totalWeight = 0;
        int time = 0;
        while(!bridgeQueue.isEmpty()){
            time++;
            totalWeight -= bridgeQueue.poll();
            if(!truckQueue.isEmpty()){
                if(totalWeight + truckQueue.peek() <= l){
                    totalWeight += truckQueue.peek();
                    bridgeQueue.add(truckQueue.poll());
                }
                else{
                    bridgeQueue.add(0);
                }
            }
        }

        System.out.println(time);
        reader.close();

    }
}

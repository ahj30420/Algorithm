package data_structure.queue;

import java.util.*;
import java.io.*;

//요세푸스 문제
public class Josephus {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        java.util.Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            queue.add(i);
        }

        int num = 1;

        sb.append("<");
        while(true){
            if(queue.size() == 1){
                sb.append(queue.poll()+">");
                break;
            }

            if(num != k){
                int target = queue.poll();
                queue.add(target);
                num++;
            }
            else{
                num = 1;
                sb.append(queue.poll()+", ");
            }
        }

        System.out.println(sb.toString());
        reader.close();

    }
}

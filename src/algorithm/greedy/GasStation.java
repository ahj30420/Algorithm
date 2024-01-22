package algorithm.greedy;

import java.util.*;
import java.io.*;

//주유소
public class GasStation {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long[] dist = new long[n-1];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine());
        long[] cost = new long[n];
        for(int i = 0; i < n; i++){
            cost[i] = Integer.parseInt(tokenizer.nextToken());
        }

        long min = cost[0];
        long result = 0;
        for(int i = 1; i < n; i++){
            result += min * dist[i-1];
            if(cost[i] < min){
                min = cost[i];
            }
        }

        System.out.println(result);
        reader.close();
    }
}

package algorithm.greedy;

import java.io.*;
import java.util.*;

//모험가 길드
public class Adventurer_Guild {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            count++;
            if(count >= arr[i]){
                result++;
                count = 0;
            }
        }

        System.out.println(result);
        reader.close();;
    }
}

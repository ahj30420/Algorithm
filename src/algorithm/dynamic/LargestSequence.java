package algorithm.dynamic;

import java.io.*;
import java.util.*;

//가장 큰 증가하는 부분 수열
public class LargestSequence {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] sequence = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        dp[0] = sequence[0];

        int maxSum = dp[0];
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(sequence[j] < sequence[i]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] += max + sequence[i];

            if(maxSum < dp[i]){
                maxSum = dp[i];
            }
        }

        System.out.println(maxSum);
        reader.close();
    }
}

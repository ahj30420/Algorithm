package algorithm.dynamic;

import java.util.*;
import java.io.*;

//개미 전사
public class AntWorrior {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[100];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
        }

        System.out.println(dp[n-1]);

        reader.close();
    }
}

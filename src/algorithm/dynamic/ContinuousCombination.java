package algorithm.dynamic;

import java.io.*;
import java.util.*;

//연속합
public class ContinuousCombination {

    private static int n;
    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];
        dp[0] = arr[0];

        int maxResult = -1001;
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
            maxResult = Math.max(maxResult, dp[i]);
        }

        maxResult = Math.max(maxResult,dp[0]);
        System.out.println(maxResult);
        reader.close();
    }
}

package algorithm.dynamic;

import java.util.*;
import java.io.*;

//병사 배치하기
public class DeploymentSoldiers {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = n-1; i >= 0 ; i--){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j <= i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            if(max < dp[i]){ max = dp[i]; }
        }

        System.out.println(n-max);
        reader.close();
    }
}

package algorithm.dynamic;

import java.util.*;
import java.io.*;

//동전2
public class Coin2 {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];

        for(int i = 0; i < n; i++){
            coin[i] = Integer.parseInt(reader.readLine());
        }

        int[] dp = new int[k+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i = 1; i <= k; i++){
            for(int j = 0; j < n; j++){
                if(i >= coin[j]){
                    dp[i] = Math.min(dp[i], dp[i-coin[j]] + 1);
                }
            }
        }

        if(dp[k] == 10001){
            System.out.println(-1);
        } else{
            System.out.println(dp[k]);
        }
        reader.close();
    }
}

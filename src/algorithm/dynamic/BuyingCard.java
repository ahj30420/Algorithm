package algorithm.dynamic;

import java.util.*;
import java.io.*;

//카드 구매하기
public class BuyingCard {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] pi = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 1; i <= n; i++){
            pi[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i-j]+pi[j],dp[i]);
            }
        }

        System.out.println(dp[n]);
        reader.close();
    }
}

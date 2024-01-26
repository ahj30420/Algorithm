package algorithm.dynamic;

import java.util.*;
import java.io.*;

//동전 1
public class Coin1 {

    private static int[] kind;
    private static int[] dp;
    private static int n,k;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kind = new int[n];
        for(int i = 0; i < n; i++){
            kind[i] = Integer.parseInt(reader.readLine());
        }

        dp = new int[k+1];

        dp[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= k; j++){
                if(j >= kind[i]){
                    dp[j] += dp[j - kind[i]];
                }
            }
        }

        System.out.println(dp[k]);
        reader.close();
    }
}

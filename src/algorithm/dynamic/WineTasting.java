package algorithm.dynamic;

import java.util.*;
import java.io.*;

// 포도주 시식
public class WineTasting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] wines = new int[n+1];
        for(int i = 1; i <= n; i++){
            wines[i] = Integer.parseInt(reader.readLine());
        }

        int[] dp = new int[n+1];
        dp[1] = wines[1];

        if(n >= 2) { dp[2] = wines[1] + wines[2]; }

        if(n >= 3) {
            for (int i = 3; i <= n; i++) {
                dp[i] = Math.max(
                        dp[i - 1]
                        ,Math.max(dp[i - 2] + wines[i], dp[i - 3] + wines[i - 1] + wines[i])
                );
            }
        }

        System.out.println(dp[n]);
        reader.close();
    }
}

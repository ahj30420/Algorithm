package algorithm.dynamic;

import java.util.*;
import java.io.*;

// 설탕 배달
public class SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        long[] dp = new long[N+1];

        Arrays.fill(dp, -1);

        if(N >= 3) { dp[3] = 1; }
        if(N >= 5) { dp[5] = 1; }

        if(N > 5) {
            for (int i = 6; i <= N; i++) {
                if (dp[i - 3] == -1 && dp[i - 5] == -1) {
                    dp[i] = -1;
                }
                if (dp[i - 3] == -1 && dp[i - 5] != -1) {
                    dp[i] = dp[i - 5] + 1;
                }
                if (dp[i - 3] != -1 && dp[i - 5] == -1) {
                    dp[i] = dp[i - 3] + 1;
                }
                if (dp[i - 3] != -1 && dp[i - 5] != -1) {
                    dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
                }
            }
        }


        System.out.println(dp[N]);
        reader.close();
    }
}

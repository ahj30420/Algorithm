package algorithm.dynamic;

import java.util.*;
import java.io.*;

//2XN 타일링
public class Tiliing2XN {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        long[] dp = new long[N+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[N]);
        reader.close();
    }
}

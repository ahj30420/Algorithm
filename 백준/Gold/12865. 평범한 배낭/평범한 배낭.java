import java.util.*;
import java.io.*;

//평번한 배낭
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[][] things = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            things[i][0] = Integer.parseInt(tokenizer.nextToken());
            things[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        int result = 0;
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (j - things[i][0] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - things[i][0]] + things[i][1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);
        reader.close();
    }
}
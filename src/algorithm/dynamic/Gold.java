package algorithm.dynamic;

import java.io.*;
import java.util.*;

//금광
public class Gold {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            int[][] arr = new int[n][m];
            int[][] dp = new int[n][m];
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++){
                for(int z = 0; z < m; z++){
                    arr[j][z] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            for(int j = 0; j < n; j++){
                for(int z = 0; z < m; z++){
                    dp[j][z] = arr[j][z];
                }
            }

            for(int z = 1; z < m; z++){
                for(int j = 0; j < n; j++){
                    int leftUp, left, leftDown;

                    if(j == 0) leftUp = 0;
                    else leftUp = dp[j-1][z-1];

                    if(j == n-1) leftDown = 0;
                    else leftDown = dp[j+1][z-1];

                    left = dp[j][z-1];

                    dp[j][z] = dp[j][z] + Math.max(leftUp,Math.max(leftDown,left));
                }
            }

            int result = 0;
            for(int j = 0; j < n; j++){
                result = Math.max(result, dp[j][m-1]);
            }
            System.out.println(result);
        }

        reader.close();
    }
}

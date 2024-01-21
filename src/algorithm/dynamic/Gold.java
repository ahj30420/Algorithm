package algorithm.dynamic;

import java.io.*;
import java.util.*;

//금광
public class Gold {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for(int i = 0; i < t; i++){

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            int[][] arr = new int[n][m];
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++){
                for(int z = 0; z < m; z++){
                    arr[j][z] = Integer.parseInt(tokenizer.nextToken());
                }
            }

            int[][] dp = new int[n][m];
            for(int j = 0; j < m; j++){
                for(int z = 0; z < n; z++){
                    if(j == 0){
                        dp[z][j] = arr[z][j];
                    } else{
                        if(z == 0){
                            dp[z][j] = Math.max(dp[z][j-1], dp[z+1][j-1]) + arr[z][j];
                        } else if(z == n-1){
                            dp[z][j] = Math.max(dp[z][j-1], dp[z-1][j-1]) + arr[z][j];
                        } else{
                            dp[z][j] = Math.max(dp[z][j-1], Math.max(dp[z-1][j-1], dp[z+1][j-1])) + arr[z][j];
                        }
                    }
                }
            }

            int max = 0;
            for(int j = 0; j < n; j++){
                if(max < dp[j][m-1]){
                    max = dp[j][m-1];
                }
            }

            System.out.println(max);
        }


        reader.close();
    }
}

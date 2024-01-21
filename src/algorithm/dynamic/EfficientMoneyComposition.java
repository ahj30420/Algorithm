package algorithm.dynamic;

import java.util.*;
import java.io.*;

//효율적인 화폐 구성
public class EfficientMoneyComposition {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] money = new int[n];
        for(int i = 0; i < n; i++){
            money[i] = Integer.parseInt(reader.readLine());
        }

        int[] dp = new int[m+1];
        Arrays.fill(dp, 10001);

        dp[0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = money[i]; j <= m; j++){
                if(dp[j - money[i]] != 10001){
                    dp[j] = Math.min(dp[j], dp[j - money[i]] + 1);
                }
            }
        }

        if(dp[m] == 10001){
            System.out.println(-1);
        }
        else{
            System.out.println(dp[m]);
        }



        reader.close();
    }
}

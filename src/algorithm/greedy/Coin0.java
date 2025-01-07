package algorithm.greedy;

import java.util.*;
import java.io.*;

// 동전0
public class Coin0 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[] coins = new int[N];
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(reader.readLine());
        }

        int result = 0;
        for(int i = N-1; i >= 0; i--) {
            result += K / coins[i];
            K %= coins[i];
        }

        System.out.println(result);
        reader.close();
    }
}

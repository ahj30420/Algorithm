package algorithm.twoPointer;

import java.util.*;
import java.io.*;

// 수열
public class Sequence {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[] temperatures = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++) {
            temperatures[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;
        int end = K-1;

        for(int i = start; i <= end; i++) {
            currentSum += temperatures[i];
        }
        maxSum = currentSum;

        for(int i = end+1; i < N; i++) {
            currentSum = currentSum - temperatures[start] + temperatures[i];
            maxSum = Math.max(maxSum, currentSum);
            start++;
        }

        System.out.println(maxSum);
        reader.close();
    }
}

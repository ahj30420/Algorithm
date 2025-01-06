package algorithm.twoPointer;

import java.util.*;
import java.io.*;

// 부분합
public class Subtotal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());

        int[] numbers = new int[N];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int start = 0;
        int end = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        while(end < N){
            currentSum += numbers[end++];

            while(currentSum >= S){
                minLength = Math.min(minLength, end - start);
                currentSum -= numbers[start++];
            }
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
        reader.close();
    }
}

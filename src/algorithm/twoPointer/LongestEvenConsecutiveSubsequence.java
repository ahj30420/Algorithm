package algorithm.twoPointer;

import java.util.*;
import java.io.*;

// 가장 긴 짝수 연속한 부분 수열 (large)
public class LongestEvenConsecutiveSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[] numbers = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int left = 0;
        int right = 0;
        int oddCount  = 0;
        int maxLength = 0;

        while(right < N) {
            if(numbers[right] % 2 != 0) {
                oddCount++;
            }

            while(oddCount  > K) {
                if(numbers[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1 - oddCount);

            right++;
        }

        System.out.println(maxLength);
        reader.close();
    }
}

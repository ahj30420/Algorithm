package algorithm.twoPointer;

import java.util.*;
import java.io.*;

// 두 용액
public class twoSolutions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] solutions = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(solutions);

        int start = 0;
        int end = N-1;
        long resultLeft = 0;
        long resultRight = 0;
        long sum = solutions[start] + solutions[end];
        long minSum = Long.MAX_VALUE;

        while(start < end) {
            if(Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                resultLeft = solutions[start];
                resultRight = solutions[end];
            }

            if(sum > 0) {
                sum -= solutions[end];
                end--;
                sum += solutions[end];
            } else if(sum < 0) {
                sum -= solutions[start];
                start++;
                sum += solutions[start];
            } else {
                resultLeft = solutions[start];
                resultRight = solutions[end];
                break;
            }
        }

        System.out.println(resultLeft + " " + resultRight);
        reader.close();
    }
}

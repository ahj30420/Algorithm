package algorithm.binarysearch;

import java.util.*;
import java.io.*;

// 예산
public class Budget {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int maxBudget = Integer.MIN_VALUE;
        int[] budget = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(tokenizer.nextToken());
            maxBudget = Math.max(maxBudget, budget[i]);
        }

        int M = Integer.parseInt(reader.readLine());

        int low = 0;
        int high = maxBudget;
        int result = 0;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(isValid(budget, M, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
        reader.close();
    }

    private static boolean isValid(int[] budgets, int totalBudget, int limit) {
        long sum = 0;
        for(int budget : budgets) {
            sum += Math.min(budget, limit);
            if(sum > totalBudget) {
                return false;
            }
        }
        return true;
    }
}

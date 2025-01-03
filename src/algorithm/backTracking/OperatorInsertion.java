package algorithm.backTracking;

import java.util.*;
import java.io.*;

// 연산자 끼워넣기
public class OperatorInsertion {

    private static int N;
    private static int[] numbers;
    private static int[] operators = new int[4];
    private static int maxResult = Integer.MIN_VALUE;
    private static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        numbers = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < 4; i++){
            operators[i] = Integer.parseInt(tokenizer.nextToken());
        }

        backTracking(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);
        reader.close();
    }

    private static void backTracking(int currentResult, int depth){
        if(depth == N){
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(operators[i] > 0){
                operators[i]--;
                int nextResult = calculate(currentResult, numbers[depth], i);
                backTracking(nextResult, depth + 1);
                operators[i]++;
            }
        }
    }

    private static int calculate(int currentResult, int number, int operator){
        switch(operator){
            case 0: return currentResult + number;
            case 1: return currentResult - number;
            case 2: return currentResult * number;
            case 3: return currentResult / number;
        }
        return -1;
    }
}

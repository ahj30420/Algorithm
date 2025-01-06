package algorithm.backTracking;

import java.util.*;
import java.io.*;

// 부분수열의 합
public class SubsequencesSum {

    private static int N, S;
    private static int[] numbers;
    private static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());

        numbers = new int[N];

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int i = 0; i < N; i++){
            backTracking(i, numbers[i]);
        }

        System.out.println(count);
        reader.close();
    }

    public static void backTracking(int current, int sum){
        if(sum == S){
            count++;
        }

        for(int i = current+1; i < N; i++){
            backTracking(i, sum + numbers[i]);
        }
    }

}

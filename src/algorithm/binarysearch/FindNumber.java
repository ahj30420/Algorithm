package algorithm.binarysearch;

import java.util.*;
import java.io.*;

// 수 찾기
public class FindNumber {

    private static int N, M;
    private static int[] arr;
    private static int[] arr2;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N  = Integer.parseInt(reader.readLine());
        arr = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(reader.readLine());
        arr2 = new int[M];
        result = new int[M];

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int i = 0; i < M; i++) {
            result[i] = binarySearch(0, N-1, arr2[i]);
        }

        for(int i = 0; i < M; i++){
            System.out.println(result[i]);
        }
        reader.close();
    }

    private static int binarySearch(int left, int right, int target) {
        if(left == right) {
            if(arr[left] == target)
                return 1;
            else
                return 0;
        }

        int mid = (left + right) / 2;

        if(arr[mid] < target) {
            return binarySearch(mid + 1, right, target);
        } else {
            return binarySearch(left, mid, target);
        }
    }
}

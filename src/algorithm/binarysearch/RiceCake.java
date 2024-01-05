package algorithm.binarysearch;

import java.io.*;
import java.util.*;

//떡볶이 떡 만들기
public class RiceCake {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);
        int max = arr[n-1];


        int result = getBinarySearch(arr, m, 0, max-1, 0);

        System.out.println(result);
        reader.close();
    }

    private static int getBinarySearch(int[] arr, int target, int start, int end, int beforestep) {
        int result = 0;
        if(start > end) { return beforestep; }
        int mid = (start + end) / 2;

        for(int i = 0; i < arr.length; i++){
            int rest = 0;
            if(arr[i] >= mid) { rest = arr[i] - mid; }
            result += rest;
        }

        if(result == target) { return mid; }

        else if(result > target) { return getBinarySearch(arr, target, mid, end, result); }

        else { return getBinarySearch(arr, target, 0, mid, result); }

    }
}

package algorithm.binarysearch;

import java.util.*;
import java.io.*;

//정렬된 배열에서 특정 수의 개수 구하기
public class SpecificNumber {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[n];

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int lowind = lowerIndx(arr,x);
        int upperind = upperInd(arr,x);

        System.out.println(upperind - lowind);
        reader.close();
    }

    public static int lowerIndx(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = (start+end) / 2;
            if(arr[mid] >= target) { end = mid; }
            else { start = mid+1; }
        }
        return end;
    }

    public static int upperInd(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            int mid = (start+end) / 2;
            if(arr[mid] > target) { end = mid; }
            else { start = mid + 1; }
        }
        return end;
    }
}

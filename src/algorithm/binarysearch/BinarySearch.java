package algorithm.binarysearch;

import java.util.*;
import java.io.*;

//이진 탐색
public class BinarySearch {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int target = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[n];

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int result = binarySearch(arr, target,0, n-1);

        if(result == -1){
            System.out.println("원소가 존재하지 않습니다.");
        }

        System.out.println(result+1);
        reader.close();
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        if(start > end) { return -1; }
        int mid = (start+end) / 2;
        if(arr[mid] == target) { return mid; }
        else if(arr[mid] > target) { return binarySearch(arr, target, start, mid); }
        else { return binarySearch(arr, target, mid, end); }
    }
}

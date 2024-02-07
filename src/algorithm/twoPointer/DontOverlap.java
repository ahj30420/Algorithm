package algorithm.twoPointer;

import java.io.*;
import java.util.*;

//겹치는 건 싫어
public class DontOverlap {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            if(max < arr[i]){
                max = arr[i];
            }
        }

        int[] count = new int[max+1];
        int maxResult = 0;
        int start = 0;
        int end = 0;

        while(end < n) {

            if(count[arr[end]] + 1 <= k){
                count[arr[end]]++;
                maxResult = Math.max(maxResult, end - start + 1);
                end++;
            } else{
                count[arr[start]]--;
                start++;
            }

        }


        System.out.println(maxResult);
        reader.close();
    }
}

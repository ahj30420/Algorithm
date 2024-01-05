package algorithm.sort;

import java.io.*;
import java.util.*;

//두 배열의 원소 교체
public class ReplaceElements {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for(int i = 0; i < n; i++){
            arr2[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            if(arr1[i] < arr2[i]){
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
            }

            else break;
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            result += arr1[i];
        }

        System.out.println(result);
        reader.close();
    }
}

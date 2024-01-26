package algorithm.binarysearch;

import java.io.*;
import java.util.*;

//용액
public class Solution {

    public static int[] solutionValue;
    public static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        solutionValue = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            solutionValue[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = n-1;
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];

        while(left < right){
            int sum = solutionValue[left] + solutionValue[right];

            if(Math.abs(sum) < minSum){
                minSum = Math.abs(sum);
                result[0] = left;
                result[1] = right;
            }

            if(sum < 0){
                left++;
            } else {
                right--;
            }

        }

        System.out.println(solutionValue[result[0]] + " " + solutionValue[result[1]]);
        reader.close();
    }

}

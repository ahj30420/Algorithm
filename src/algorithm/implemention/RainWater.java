package algorithm.implemention;

import java.util.*;
import java.io.*;

//빗물
public class RainWater {

    private static int[] block;
    private static int h,w;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        block = new int[w];

        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < w; i++){
            block[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 1; i < w-1; i++){
            int leftMax = findMax(0,i-1);
            int rightMax = findMax(i+1, w-1);

            int minHeight = Math.min(leftMax, rightMax);

            if(minHeight > block[i]){
                result += minHeight - block[i];
            }
        }

        System.out.println(result);
        reader.close();
    }

    private static int findMax(int start, int end){
        int max = 0;

        for(int i = start; i <= end; i++){
            max = Math.max(max, block[i]);
        }

        return max;
    }

}

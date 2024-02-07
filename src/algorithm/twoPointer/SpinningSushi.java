package algorithm.twoPointer;

import java.util.*;
import java.io.*;

//회전 초밥
public class SpinningSushi {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] plate = new int[n];
        for(int i = 0; i < n; i++){
            plate[i] = Integer.parseInt(reader.readLine());
        }

        int[] eaten = new int[d+1];
        int start = 0; int end = 0;


        reader.close();
    }
}

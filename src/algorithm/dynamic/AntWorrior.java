package algorithm.dynamic;

import java.util.*;
import java.io.*;

//개미 전사
public class AntWorrior {

    public static int[] d = new int[100];

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < n; i++){
            d[i] = Math.max(d[i-1], d[i-2]+arr[i]);
        }

        System.out.println(d[n-1]);
        reader.close();
    }
}

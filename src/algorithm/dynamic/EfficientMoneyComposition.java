package algorithm.dynamic;

import java.util.*;
import java.io.*;

//효율적인 화폐 구성
public class EfficientMoneyComposition {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int[] d = new int[m+1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = arr[i]; j <= m; j++){
                if(d[j-arr[i]] != -1){
                    d[j] = Math.min(d[j], d[j-arr[i]] + 1);
                }
            }
        }

        if(d[m] == 10001) System.out.println(-1);
        System.out.println(d[m]);
        reader.close();
    }
}

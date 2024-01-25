package algorithm.binarysearch;

import java.util.*;
import java.io.*;

//용돈 관리
public class MoneyManagement {

    private static int[] todayMoney;
    private static int n,m;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        todayMoney = new int[n];

        int maxK = 0;
        for(int i = 0; i < n; i++){
            todayMoney[i] = Integer.parseInt(reader.readLine());
            maxK = Math.max(maxK, todayMoney[i]);
        }

        int result = binarySearch(maxK,(int) 1e9);

        System.out.println(result);
        reader.close();
    }

    private static int binarySearch(int start, int end){
        int result = 0;

        while(start <= end){
            int mid = (start+end) / 2;

            if(checkM(mid)){
                result = mid;
                end = mid-1;
            } else{
                start = mid + 1;
            }

        }

        return result;
    }

    private static boolean checkM(int k){
        int count = 1;
        int remainMoney = k;

        for(int i = 0; i < n; i++){
            if(todayMoney[i] > remainMoney){
                count++;
                remainMoney = k;
            }
            remainMoney -= todayMoney[i];
        }

        return count <= m;
    }

}

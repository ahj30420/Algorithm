package algorithm.binarysearch;

import java.util.*;
import java.io.*;

//공유기 설치
public class InstallRouter {

    private static int[] arr;
    private static int n,c;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(arr);

        int maxDist = (int) Math.ceil(arr[0]+arr[n-1]);

        int result = binarySearch(1, maxDist);

        System.out.println(result);
        reader.close();
    }

    private static int binarySearch(int start, int end){
        int result = 0;

        while(start <= end){
            int mid = (start+end) / 2;

            if(check(mid)){
                result = mid;
                start = mid+1;
            } else{
                end = mid - 1;
            }
        }

        return result;
    }

    private static boolean check(int dist){
        int routerCount = 1;
        int lastInstalled = arr[0];

        for(int i = 1; i < n; i++){
            if(arr[i] - lastInstalled >= dist){
                routerCount++;
                lastInstalled = arr[i];
            }
        }

        return routerCount >= c;
    }

}

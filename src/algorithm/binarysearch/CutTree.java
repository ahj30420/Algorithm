package algorithm.binarysearch;

import java.util.*;
import java.io.*;

//나무 자르기
public class CutTree {

    public static int[] treeList;
    public static int n, m;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int maxTree = 0;
        treeList = new int[n];
        st = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            treeList[i] = Integer.parseInt(st.nextToken());
            if(maxTree < treeList[i]){ maxTree = treeList[i]; }
        }

        int result = binarySearch(maxTree);

        System.out.println(result);
        reader.close();
    }

    private static int binarySearch(int maxTree){
        int start = 0;
        int end = maxTree;

        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            long total = 0;

            for(int i = 0; i < n; i++){
                if(treeList[i] > mid){
                    total += treeList[i] - mid;
                }
            }

            if(total >= m){
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

}

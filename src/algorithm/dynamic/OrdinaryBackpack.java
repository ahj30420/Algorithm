package algorithm.dynamic;

import java.util.*;
import java.io.*;

//평번한 배낭
public class OrdinaryBackpack {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Item[] itemList = new Item[n+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(reader.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            itemList[i] = new Item(w,v);
        }

        int[][] dp = new int[n+1][k+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                if(j >= itemList[i].getW()){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-itemList[i].getW()] + itemList[i].getV());
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        System.out.println(dp[n][k]);
        reader.close();
    }

    private static class Item{
        private int w;
        private int v;

        public Item(int w, int v){
            this.w = w;
            this.v = v;
        }

        public int getW(){ return w; }

        public int getV(){ return v; }
    }

}

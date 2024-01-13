package algorithm.DFS;

import java.util.*;
import java.io.*;

//음료수 얼려 먹기
public class FreezeDrink {

    public static int n,m;
    public static int[][] map = new int[1000][1000];

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        for(int i = 0; i < n; i++){
            String target = reader.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = target.charAt(j) - '0';
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(i,j)){
                    count++;
                }
            }
        }

        System.out.println(count);
        reader.close();
    }

    private static boolean dfs(int i, int j){
        if(i < 0 || i >= n || j < 0 || j >= m || map[i][j] != 0) { return false; }

        map[i][j] = 1;

        dfs(i,j+1);
        dfs(i, j-1);
        dfs(i+1,j);
        dfs(i-1,j);

        return true;
    }

}

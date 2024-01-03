package algorithm.DFS;

import java.util.*;
import java.io.*;

//음료수 얼려 먹기
public class FreezeDrink {

    public static int n,m;
    public static int[][] graph = new int[1000][1000];

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        for(int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            String target = tokenizer.nextToken();
            for(int j = 0; j < m; j++){
                int x = target.charAt(j) - '0';
                graph[i][j] = x;
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(dfs(i, j)){
                    result += 1;
                }
            }
        }

        System.out.println(result);
        reader.close();
    }

    private static boolean dfs(int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m){ return false; }

        if(graph[i][j] == 0){

            graph[i][j] = 1;

            dfs(i-1, j);
            dfs(i, j+1);
            dfs(i+1, j);
            dfs(i, j-1);
            return true;
        }
        return false;
    }
}

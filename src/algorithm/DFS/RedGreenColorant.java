package algorithm.DFS;

import java.io.*;
import java.util.*;

//적록 색약
public class RedGreenColorant {

    private static char[][] arr;
    private static boolean[][] visited;
    private static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(reader.readLine());
        arr = new char[n][n];

        for(int i = 0; i < n; i++){
            String target = reader.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = target.charAt(j);
            }
        }

        visited = new boolean[n][n];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
               count += dfs(i,j,arr[i][j]);
            }
        }
        sb.append(count + " ");

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 'G'){
                    arr[i][j] = 'R';
                }
            }
        }

        visited = new boolean[n][n];
        count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                count += dfs(i,j,arr[i][j]);
            }
        }
        sb.append(count + " ");

        System.out.println(sb.toString());
        reader.close();
    }

    private static int dfs(int i, int j, char color){
        if(i < 0 || i >= n || j < 0 || j >= n || arr[i][j] != color || visited[i][j]){
            return 0;
        } else{
            visited[i][j] = true;
            dfs(i+1,j,color);
            dfs(i-1,j,color);
            dfs(i,j+1,color);
            dfs(i,j-1,color);
            return 1;
        }
    }

}

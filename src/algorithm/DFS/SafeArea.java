package algorithm.DFS;

import java.util.*;
import java.io.*;

//안전 영역
public class SafeArea {

    public static int[][] map;
    public static boolean[][] visited;
    public static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        int maxHigh = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHigh = Math.max(map[i][j],maxHigh);
            }
        }

        int result = 0;
        for(int z = 0; z < maxHigh; z++){
            visited = new boolean[n][n];
            int safeArea = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] > z && !visited[i][j]){
                        dfs(i,j,z);
                        safeArea++;
                    }
                }
            }
            result = Math.max(result, safeArea);
        }

        System.out.println(result);
        reader.close();
    }

    private static void dfs(int y, int x, int rain){
        if(x < 0 || x >= n || y < 0 || y >= n || map[y][x] <= rain || visited[y][x]){ return; }

        visited[y][x] = true;

        dfs(y,x+1,rain);
        dfs(y+1,x,rain);
        dfs(y,x-1,rain);
        dfs(y-1,x,rain);
    }
}
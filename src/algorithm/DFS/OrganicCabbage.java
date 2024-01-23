package algorithm.DFS;

import java.util.*;
import java.io.*;

//유기농 배추
public class OrganicCabbage {

    public static int[][] map;
    public static int n,m,k;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(reader.readLine());

        for(int z = 0; z < testCase; z++){

            StringTokenizer st = new StringTokenizer(reader.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[n][m];

            for(int i = 0; i < k; i++){
                st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    count += dfs(i,j);
                }
            }

            sb.append(count+"\n");
        }

        System.out.println(sb.toString());
        reader.close();
    }

    private static int dfs(int y, int x) {
        if(x >= 0 && x < m && y >= 0 && y < n && map[y][x] == 1){
            map[y][x] = 2;
            dfs(y-1,x);
            dfs(y,x+1);
            dfs(y+1, x);
            dfs(y,x-1);
            return 1;
        }
        return 0;
    }

}

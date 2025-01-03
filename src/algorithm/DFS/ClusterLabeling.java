package algorithm.DFS;

import java.util.*;
import java.io.*;

// 단지번호붙이기
public class ClusterLabeling {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    private static int each = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();

        int N = Integer.parseInt(reader.readLine());

        boolean[][] visited = new boolean[N][N];
        int[][] maps = new int[N][N];
        for(int i = 0; i < N; i++){
            String line = reader.readLine();
            for(int j = 0; j < N; j++){
                maps[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && maps[i][j] == 1) {
                    dfs(maps, visited, i, j);
                    result.add(each);
                    each = 0;
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        reader.close();
    }

    private static void dfs(int[][] maps, boolean[][] visited, int x, int y){
        if(x >= 0 && x < maps.length && y >= 0 && y < maps[0].length && maps[x][y] == 1 && !visited[x][y]){
            each++;
            visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                dfs(maps, visited, x + dx[i], y + dy[i]);
            }
        }
    }
}

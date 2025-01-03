package algorithm.BFS;

import java.util.*;
import java.io.*;

// 그림
public class Painting {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        List<Integer> result = new ArrayList<>();

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        boolean[][] visited = new boolean[n][m];
        int[][] paintings = new int[n][m];
        for(int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < m; j++){
                paintings[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && paintings[i][j] == 1) {
                    result.add(bfs(paintings, visited, i, j));
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        if(!result.isEmpty()) {
            System.out.println(result.get(result.size()-1));
        } else{
            System.out.println(0);
        }

        reader.close();
    }

    private static int bfs(int[][] paintings, boolean[][] visited, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        int count = 1;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < paintings.length && ny >= 0 && ny < paintings[0].length && paintings[nx][ny] == 1 && !visited[nx][ny]){
                    queue.add(new int[] {nx, ny});
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return count;
    }
}

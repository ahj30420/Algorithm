package algorithm.BFS;

import java.io.*;
import java.util.*;

//미로 탈출
public class EscapeMaze {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            String target = reader.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = target.charAt(j) - '0';
            }
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        int[] start = {0,0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            int y = loc[0];
            int x = loc[1];

            for(int i = 0; i < 4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx < 0 || cx >= m || cy < 0 || cy >= n || map[cy][cx] == 0) {continue;}

                if(map[cy][cx] == 1) {
                    map[cy][cx] = map[y][x] + 1;
                    int[] nextLoc = {cy,cx};
                    queue.add(nextLoc);
                }
            }
        }
        
        System.out.println(map[n-1][m-1]);
        reader.close();
    }
}


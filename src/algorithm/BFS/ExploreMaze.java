package algorithm.BFS;

import java.util.*;
import java.io.*;

//미로 찾기
public class ExploreMaze {

    public static int[][] maze;
    public static int n,m;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];

        for(int i = 0; i < n; i++){
            String target = reader.readLine();
            for(int j = 0; j < m; j++){
                maze[i][j] = target.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(maze[n-1][m-1]+1);
        reader.close();
    }

    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};

        queue.add(new int[]{0,0});
        maze[0][0] = 0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = node[1] + dx[i];
                int ny = node[0] + dy[i];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && maze[ny][nx] == 1){
                    maze[ny][nx] = maze[node[0]][node[1]] + 1;
                    queue.add(new int[]{ny,nx});
                }
            }
        }

    }

}

package algorithm.BFS;

import java.util.*;
import java.io.*;

//음식물 피하기
public class AvoidingFood {

    public static int[][] map;
    public static int maxTrashSize = 0;
    public static int n,m,k;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(reader.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;

            map[y][x] = 1;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bfs(i,j);
            }
        }

        System.out.println(maxTrashSize);
        reader.close();
    }

    private static void bfs(int y, int x){
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};

        queue.add(new int[]{y,x});

        if(map[y][x] == 1) {
            map[y][x] = 2;
            int count = 0;
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                count++;

                for (int i = 0; i < 4; i++) {
                    int ny = node[0] + dy[i];
                    int nx = node[1] + dx[i];

                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 1) {
                        queue.add(new int[] {ny,nx});
                        map[ny][nx] = 2;
                    }
                }
            }

            maxTrashSize = Math.max(maxTrashSize, count);
        } else{
            return;
        }
    }

}

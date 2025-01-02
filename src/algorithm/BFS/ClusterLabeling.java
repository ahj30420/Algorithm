package algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지번호붙이기
public class ClusterLabeling {

    private final static int[] dx = {1, -1, 0, 0};
    private final static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();
        int N  = Integer.parseInt(reader.readLine());

        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            String line = reader.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    result.add(bfs(map, i, j));
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());

        for(int size : result){
            System.out.println(size);
        }

        reader.close();
    }

    private static int bfs(int[][] map, int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        map[x][y] = 2;
        int result = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] == 1) {
                    map[nx][ny] = 2;
                    queue.add(new int[]{nx, ny});
                    result++;
                }
            }
        }

        return result;
    }
}

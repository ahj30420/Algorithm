package algorithm.BFS;

import java.util.*;
import java.io.*;

// 공주님을 구해라!
public class SavePrincess {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int T = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][] times = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0, 0});
        times[0][0] = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int ct = current[2];
            int hasWeapon = current[3];

            if(map[cx][cy] == 2) {
                map[cx][cy] = 0;
                hasWeapon = 1;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nt = ct + 1;

                if(hasWeapon != 1) {
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1 && times[nx][ny] > nt) {
                        queue.add(new int[]{nx, ny, nt, 0});
                        times[nx][ny] = nt;
                    }
                } else {
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 3) {
                        queue.add(new int[]{nx, ny, nt, 1});
                        map[nx][ny] = 3;
                        if(times[nx][ny] > nt) {
                            times[nx][ny] = nt;
                        }
                    }
                }
            }
        }

        if(times[N-1][M-1] <= T){
            System.out.println(times[N-1][M-1]);
        } else{
            System.out.println("Fail");
        }
        reader.close();
    }
}

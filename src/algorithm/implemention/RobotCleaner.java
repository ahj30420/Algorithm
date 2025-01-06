package algorithm.implemention;

import java.io.*;
import java.util.*;

// 로봇 청소기
public class RobotCleaner {

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        int cx = Integer.parseInt(tokenizer.nextToken());
        int cy = Integer.parseInt(tokenizer.nextToken());
        int cd = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int result = 0;
        boolean canWork = true;
        while(canWork) {
            if(map[cx][cy] == 0) {
                map[cx][cy] = 2;
                result++;
            }

            boolean fowardPossible = false;
            for(int i = 0; i < 4; i++){
                int nd = (cd + 3) % 4;
                int nx = cx + dx[nd];
                int ny = cy + dy[nd];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0){
                    cx = nx;
                    cy = ny;
                    cd = nd;
                    fowardPossible = true;
                    break;
                }
                cd = nd;
            }

            if(!fowardPossible){
                int nx = cx + dx[(cd + 2) % 4];
                int ny = cy + dy[(cd + 2) % 4];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1){
                    cx = nx;
                    cy = ny;
                } else {
                    canWork = false;
                }
            }
        }

        System.out.println(result);
        reader.close();
    }
}

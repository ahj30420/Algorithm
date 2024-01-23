package algorithm.implemention;

import java.io.*;
import java.util.*;

//로봇 청소기
public class RobotCleaner {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int ndy = Integer.parseInt(tokenizer.nextToken());
        int ndx = Integer.parseInt(tokenizer.nextToken());
        int nd = Integer.parseInt(tokenizer.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int count = 0;

        while (true) {
            // 현재 위치 청소
            if (map[ndy][ndx] == 0) {
                map[ndy][ndx] = 2;
                count++;
            }

            boolean move = false;

            for (int i = 0; i < 4; i++) {
                int cd = (nd + 3) % 4;
                int cdy = ndy + dy[cd];
                int cdx = ndx + dx[cd];

                if (cdx >= 0 && cdx < m && cdy >= 0 && cdy < n && map[cdy][cdx] == 0) {
                    nd = cd;
                    ndy = cdy;
                    ndx = cdx;
                    move = true;
                    break;
                }
                nd = cd;
            }

            if (!move) {
                int cdy = ndy + dy[(nd + 2) % 4];
                int cdx = ndx + dx[(nd + 2) % 4];

                if (cdx >= 0 && cdx < m && cdy >= 0 && cdy < n && map[cdy][cdx] != 1) {
                    ndy = cdy;
                    ndx = cdx;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
        reader.close();
    }
}

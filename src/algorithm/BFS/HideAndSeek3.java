package algorithm.BFS;

import java.util.*;
import java.io.*;

// 숨바꼴질3
public class HideAndSeek3 {

    static final char[] dx = {'-', '+', '*'};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[] map = new int[100001];
        Arrays.fill(map, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});
        map[N] = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int ct = current[1];

            for(int i = 0; i < 3; i++) {
                int nx = nextLocation(cx, dx[i]);
                int nt = nextTime(ct, dx[i]);

                if(nx >= 0 && nx < map.length && nt < map[nx]) {
                    queue.add(new int[] {nx, nt});
                    map[nx] = nt;
                }
            }
        }

        System.out.println(map[K]);
        reader.close();
    }

    private static int nextLocation(int current, char calculator) {
        int result = 0;
        switch(calculator) {
            case '-':
                result = current - 1;
                break;

            case '+':
                result = current + 1;
                break;

            case '*':
                result = current * 2;
                break;
        }

        return result;
    }

    private static int nextTime(int current, char calculator) {
        if(calculator == '*') {
            return current;
        } else {
            return current + 1;
        }
    }
}

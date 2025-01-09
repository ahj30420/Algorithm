package algorithm.Graph;

import java.util.*;
import java.io.*;

// 운동
public class WorkOut {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());

        int[][] dist = new int[V + 1][V + 1];
        for(int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], 1000000000);
        }

        for(int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            dist[u][v] = w;
        }

        for(int k = 1; k <= V; k++) {
            for(int i = 1; i <= V; i++) {
                for(int j = 1; j <= V; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int minCycle = 1000000000;
        for(int i = 1; i <= V; i++) {
            minCycle = Math.min(minCycle, dist[i][i]);
        }

        if(minCycle == 1000000000) {
            System.out.println(-1);
        } else {
            System.out.println(minCycle);
        }
        reader.close();
    }
}

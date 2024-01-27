package algorithm.Graph;

import java.util.*;
import java.io.*;

//미래 도시
public class FutureCity {

    public static final int INF = (int) 1e9;
    public static int n,m;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        for(int i = 0; i <= n; i++){
            Arrays.fill(graph[i], INF);
        }

        for(int i = 1; i <= n; i++){
            graph[i][i] = 0;
        }

        for(int i = 0; i < m; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for(int z = 1; z <= n; z++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][z] + graph[z][b]);
                }
            }
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        if(graph[1][k] == INF || graph[k][x] == INF){
            System.out.println(-1);
        } else{
            System.out.println(graph[1][k] + graph[k][x]);
        }
    }
}

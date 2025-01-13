package algorithm.backTracking;

import java.io.*;
import java.util.*;

// ABCDE
public class ABCDE {

    private static boolean found;
    private static boolean[] visited;
    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            if(!found) {
                backTracking(i, 0);
            }
        }

        System.out.println(found ? 1 : 0);
        reader.close();
    }

    private static void backTracking(int startNode, int depth) {
        if(depth == 4) {
            found = true;
            return;
        }

        visited[startNode] = true;

        for(int neighbor : graph[startNode]) {
            if(!visited[neighbor]) {
                backTracking(neighbor, depth + 1);
            }
        }

        visited[startNode] = false;
    }
}

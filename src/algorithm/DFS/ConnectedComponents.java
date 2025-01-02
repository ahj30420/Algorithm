package algorithm.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class ConnectedComponents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(graph, visited, i);
                count++;
            }
        }

        System.out.println(count);
        reader.close();
    }

    private static void dfs(List<Integer>[] graph, boolean[] visited, int u){
        visited[u] = true;

        for(int i : graph[u]){
            if(!visited[i]){
                dfs(graph, visited, i);
            }
        }
    }
}

package algorithm.MST;

import java.util.*;
import java.io.*;

// 네트워크 연결
public class NetworkConnection {

    static class Edge implements Comparable<Edge> {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        List<Edge>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,0));
        int toalWeight = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if(visited[current.vertex]) continue;

            visited[current.vertex] = true;
            toalWeight += current.weight;

            for(Edge neighbor : graph[current.vertex]) {
                if(!visited[neighbor.vertex])
                    pq.add(neighbor);
            }
        }

        System.out.println(toalWeight);
        reader.close();
    }
}

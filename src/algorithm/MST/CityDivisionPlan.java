package algorithm.MST;

import java.util.*;
import java.io.*;

// 도시 분할 계획
public class CityDivisionPlan {

    static class Edge implements Comparable<Edge> {
            int vertex, weight;

            public Edge(int v, int w){
                this.vertex = v;
                this.weight = w;
            }

            @Override
            public int compareTo(Edge other){
                return this.weight - other.weight;
            }
        }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        List<Edge>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
        }

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        int maxEdge = Integer.MIN_VALUE;
        int totalWeight = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if(visited[current.vertex]) continue;
            visited[current.vertex] = true;

            totalWeight += current.weight;
            maxEdge = Math.max(maxEdge, current.weight);

            for(Edge neighbor : graph[current.vertex]) {
                if(!visited[neighbor.vertex])
                    pq.add(neighbor);
            }
        }

        System.out.println(totalWeight - maxEdge);
        reader.close();
    }
}

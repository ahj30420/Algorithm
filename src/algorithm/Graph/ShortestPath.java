package algorithm.Graph;

import java.util.*;
import java.io.*;

// 최단 경로
public class ShortestPath {

    static class Edge implements Comparable<Edge> {
        int vertex, weight;

        public Edge(int v, int w) {
            this.vertex = v;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int V = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(reader.readLine());

        List<Edge>[] graph = new ArrayList[V + 1];
        int[] weights = new int[V + 1];
        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            weights[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            graph[u].add(new Edge(v,w));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(K,0));
        weights[K] = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            for(Edge neighbor : graph[current.vertex]) {
                int nextVertex = neighbor.vertex;
                int nextWeight = current.weight + neighbor.weight;

                if(nextWeight < weights[nextVertex]) {
                    pq.add(new Edge(nextVertex, nextWeight));
                    weights[nextVertex] = nextWeight;
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if(weights[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else{
                System.out.println(weights[i]);
            }
        }
        reader.close();
    }
}

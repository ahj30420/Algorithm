package algorithm.Graph;

import java.util.*;
import java.io.*;

// 최소비용 구하기
public class FindMinimumCost {

    static class Edge implements Comparable<Edge> {
        int vertex, weight;

        public Edge(int v, int w) {
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
        StringTokenizer tokenizer;

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        List<Edge>[] graph = new ArrayList[N + 1];
        int[] weights = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            weights[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            graph[u].add(new Edge(v, w));
        }

        tokenizer = new StringTokenizer(reader.readLine());

        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        weights[start] = 0;

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if(current.weight > weights[current.vertex]) continue;

            for(Edge neighbor : graph[current.vertex]) {
                int nextVertex = neighbor.vertex;
                int nextWeight = current.weight + neighbor.weight;

                if(nextWeight < weights[nextVertex]) {
                    pq.add(new Edge(nextVertex, nextWeight));
                    weights[nextVertex] = nextWeight;
                }
            }
        }

        System.out.println(weights[end]);
        reader.close();
    }
}

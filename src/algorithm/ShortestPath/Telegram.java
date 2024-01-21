package algorithm.ShortestPath;

import java.util.*;
import java.io.*;

//전보
public class Telegram {

    public static final int INF = (int) 1e9;
    public static int n,m,start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] table = new int[30001];

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        start = Integer.parseInt(tokenizer.nextToken());

        Arrays.fill(table, INF);

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i = 0; i < m; i++){
            tokenizer = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            int z = Integer.parseInt(tokenizer.nextToken());
            graph.get(x).add(new Node(y,z));
        }

        dijkstra(start);

        int count = 0;
        int maxDist = 0;
        for(int i = 1; i < n; i++){
            if(table[i] != INF){
                if(maxDist < table[i]){
                    maxDist = table[i];
                }
                count++;
            }
        }

        System.out.println(count + " " + maxDist);
        reader.close();
    }

    private static class Node implements Comparable<Node> {

        private int index;
        private int distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        public int getIndex(){
            return index;
        }

        public int getDistance(){
            return distance;
        }

        @Override
        public int compareTo(Node other){
            if(this.distance < other.distance){
                return -1;
            }
            return 1;
        }
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));
        table[start] = 0;

        while(!pq.isEmpty()){

            Node node = pq.poll();
            int now = node.index;
            int dist = node.distance;

            if(table[now] < dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = table[now] + graph.get(now).get(i).getDistance();

                if(cost < table[graph.get(now).get(i).getIndex()]) {
                    table[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

}

package algorithm.Graph;

import java.util.*;
import java.io.*;

//택배 배송
public class CourierDelivery {

    private static final int INF = (int) 1e9;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    private static int n,m;
    private static int[] d;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Node>());
        }

        d = new int[n+1];
        Arrays.fill(d, INF);

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, dist));
            graph.get(end).add(new Node(start, dist));
        }

        dijkstra(1);

        System.out.println(d[n]);
        reader.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Node node = new Node(start,0);
        pq.offer(node);
        d[start] = 0;

        while(!pq.isEmpty()){
            Node target = pq.poll();

            int now = target.getIndex();
            int dist = target.getDist();

            if(d[now] < dist) { continue; }

            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDist();

                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }

        }

    }

    private static class Node implements Comparable<Node>{

        private int index;
        private int dist;

        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }

        public int getIndex(){
            return this.index;
        }

        public int getDist(){
            return this.dist;
        }

        @Override
        public int compareTo(Node other){
            if(this.dist < other.dist){
                return -1;
            }
            return 1;
        }
    }

}

package algorithm.Graph;

import java.util.*;
import java.io.*;

//지름길
public class ShortCut {

    private static final int INF = (int) 1e9;
    private static ArrayList<ArrayList<Node>> road = new ArrayList<ArrayList<Node>>();
    private static int n,d;
    private static int[] dist;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < d+1; i++){
            road.add(new ArrayList<Node>());
            if(i < d) {
                road.get(i).add(new Node(i + 1, 1));
            }
        }

        dist = new int[d+1];
        Arrays.fill(dist, INF);

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int shortcut = Integer.parseInt(st.nextToken());

            if(end <= d) {
                road.get(start).add(new Node(end, shortcut));
            }
        }

        dijkstra(0);

        System.out.println(dist[d]);
        reader.close();
    }

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Node node = new Node(0,0);
        pq.offer(node);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node target = pq.poll();

            int now = target.getIndex();
            int distance = target.getDistance();

            if(dist[now] < distance) {continue;}

            for(int i = 0; i < road.get(now).size(); i++){
                int cost = dist[now] + road.get(now).get(i).getDistance();

                if(cost < dist[road.get(now).get(i).getIndex()]){
                    dist[road.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(road.get(now).get(i).getIndex(), cost));
                }
            }

        }

    }

    private static class Node implements Comparable<Node>{

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

}

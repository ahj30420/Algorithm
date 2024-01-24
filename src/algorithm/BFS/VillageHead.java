package algorithm.BFS;

import java.util.*;
import java.io.*;

//촌수 계산
public class VillageHead {

    public static List<List<Integer>> relation = new ArrayList<List<Integer>>();
    public static boolean[] visited;
    public static int n;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int relationCount = Integer.parseInt(reader.readLine());
        visited = new boolean[relationCount*2];
        for(int i = 0; i <= relationCount*2; i++){
            relation.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < relationCount; i++){
            st = new StringTokenizer(reader.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            relation.get(parent).add(child);
            relation.get(child).add(parent);
        }

        int result = bfs(start,end);

        System.out.println(result);
        reader.close();
    }

    private static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int[] length = new int[n*2+1];

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i = 0; i < relation.get(node).size(); i++){
                int nextNode = relation.get(node).get(i);

                if(visited[nextNode] == false){
                    length[nextNode] = length[node] + 1;
                    queue.add(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

        if(length[end] == 0){
            return -1;
        } else{
            return length[end];
        }

    }
}

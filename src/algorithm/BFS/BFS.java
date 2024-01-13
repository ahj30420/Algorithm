package algorithm.BFS;

import java.util.*;

//너비 우선 탐색
public class BFS {
    public static void main(String[] args){

        int n = 1;
        int[][] graph = {
                {},
                {2,3,8},
                {1,7},
                {1,4,5},
                {3,5},
                {3,4},
                {7},
                {2,6,8},
                {1,7}
        };

        boolean[] visited = new boolean[9];

        visited[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.println(x + " ");

            for(int i = 0; i < graph[x].length; i++){
                int k = graph[x][i];
                if(!visited[k]){
                    queue.add(k);
                    visited[k] = true;
                }
            }
        }

    }
}

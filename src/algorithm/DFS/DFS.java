package algorithm.DFS;

//깊이 우선 탐색
public class DFS {
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

        dfs(n,graph,visited);
    }

    private static void dfs(int x, int[][] graph, boolean[] visited){
        visited[x] = true;

        System.out.println(x + " ");

        for(int i = 0; i < graph[x].length; i++){
            int k = graph[x][i];
            if(!visited[k]) { dfs(k, graph, visited); }
        }

    }
}

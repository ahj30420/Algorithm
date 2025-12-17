import java.util.*;

class Solution {
    
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[] columnSum = new int[m];
    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[j][i] == 1 && !visited[j][i]) {
                    bfs(j, i, land, visited, columnSum);
                }
            }
        }
        
        int answer = 0;
        for (int sum : columnSum) {
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
    
    private void bfs(int x, int y, int[][] land, boolean[][] visited, int[] columnSum) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> columns = new HashSet<>();
        
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        columns.add(y);
        int sum = 1;
        
        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            int cx = currentPos[0];
            int cy = currentPos[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < land.length && 
                    ny >= 0 && ny < land[0].length && 
                    !visited[nx][ny] && land[nx][ny] == 1) {
                    queue.add(new int[] {nx, ny});
                    columns.add(ny);
                    visited[nx][ny] = true;
                    sum++;
                }
            }
        }
        
        for (int col : columns) {
            columnSum[col] += sum;
        }
    }
}
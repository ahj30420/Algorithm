import java.util.*;

class Solution {
    
    private char[][] map;
    private int n,m;
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        
        map = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String target = storage[i];
            for (int j = 0; j < m; j++) {
                map[i][j] = target.charAt(j);
            }
        }
        
        int removeContainerCount = 0;
        for (String request : requests) {
            removeContainerCount += removeContainer(request);
        }
        
        return n * m - removeContainerCount;
    }
    
    private int removeContainer(String request) {
        char requestChar = request.charAt(0);
        if (request.length() == 1) {
            return removeOuterContainerReuqest(requestChar);
        } else {
            return removeAllContainerRequest(requestChar);
        }
    }
    
    private int removeOuterContainerReuqest(char request) {
        boolean[][] toRemove = new boolean[n][m];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {        
                if (map[i][j] != request) continue;
                if (BFS(i,j)){
                    toRemove[i][j] = true;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (toRemove[i][j]) {
                    map[i][j] = '0';
                    count++;
                }
            }
        }    
        return count;
    }
    
    private boolean BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        
        boolean[][] visited = new boolean[n][m];
        boolean possible = false; 
        while(!queue.isEmpty()) {
            int[] currentPos = queue.poll();    
            int cx = currentPos[0];
            int cy = currentPos[1];
            
            if (cx == 0 || cx == n-1 || cy == 0 || cy == m-1) {
                possible = true;
                break;
            }
            
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == '0' && !visited[nx][ny])
                {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }       
            }
        }
        
        return possible;
    }
    
    private int removeAllContainerRequest(char request) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == request) {
                    map[i][j] = '0';
                    count++;
                }
            }
        }
        return count;
    }
}
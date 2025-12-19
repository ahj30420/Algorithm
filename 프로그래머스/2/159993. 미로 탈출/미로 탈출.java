import java.util.*;

class Solution {
    
    private char[][] map;
    private final int[] dx = {-1, 0, 1, 0};
    private final int[] dy = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
    
        int[] start = null;
        int[] lever = null;
        int[] exit = null;
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') { start = new int[] {i,j}; }
                if (c == 'L') { lever = new int[] {i,j}; }
                if (c == 'E') { exit = new int[] {i,j}; }
                map[i][j] = c;
            }
        }
        
        int toLever = bfs(start, lever);
        if (toLever == -1) {
            return -1;
        }
        
        int toExit = bfs(lever, exit);
        if (toExit == -1) {
            return -1;
        }
        
        return toLever + toExit;
    }
    
    private int bfs(int[] start, int[] target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length];
        
        queue.add(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int cx = curPos[0];
            int cy = curPos[1];
            int cd = curPos[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;
                
                if (nx >= 0 && nx < map.length && 
                    ny >= 0 && ny < map[0].length && 
                    !visited[nx][ny] && map[nx][ny] != 'X') 
                {
                    if (nx == target[0] && ny == target[1]) {
                        return nd;
                    }
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx,ny,nd});
                }
            }
        }
        
        return -1;
    }
}
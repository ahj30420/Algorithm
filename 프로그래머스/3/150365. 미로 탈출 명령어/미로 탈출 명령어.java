import java.util.*;

class Solution {
    
    private final String[] dir = {"d", "l", "r", "u"};
    private final int[] dx = {1, 0, 0, -1};
    private final int[] dy = {0, -1, 1, 0};
    private String answer = "impossible";
    private int n, m, r, c, k;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        
        dfs("", x-1, y-1, 0);
        
        return answer;
    }
    
    private boolean dfs(String path, int currentX, int currentY, int currentDepth) {
        if (currentX < 0 || currentX >= n || currentY < 0 || currentY >= m) return false;
        
        int remaining = k - currentDepth;
        int dist = Math.abs(r - 1 - currentX) + Math.abs(c - 1 - currentY);
        
        if (dist > remaining || (remaining - dist) % 2 != 0) return false;
        
        if (currentDepth == k) {
            if (currentX == r-1 && currentY == c-1) {
                answer = path;
                return true;
            }
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
           if (dfs(path + dir[i], currentX + dx[i], currentY + dy[i], currentDepth + 1)) return true;
        }
        
        return false;
    }
}
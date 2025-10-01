import java.util.*;

class Solution {
    
    private int n, m;
    private int[] emoticons;
    private int[][] users;
    private int[] emoticonDiscounts;
    private Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;
        this.users = users;
        this.emoticons = emoticons;
        this.emoticonDiscounts = new int[m];
        
        map.put("plus", 0);
        map.put("sales", 0);
        
        backTracking(0, m);
        
        int[] answer = new int[] {map.get("plus"), map.get("sales")};
        return answer;
    }
    
    private void backTracking(int currentDepth, int targetDepth) {
        if (currentDepth == targetDepth) {
            int plusCount = 0;
            int totalSales = 0;
            for (int i = 0; i < n; i++) {
                int sales = 0;
                for (int j = 0; j < m; j++) {
                    if (users[i][0] <= emoticonDiscounts[j]) {
                        sales += emoticons[j] * (1 - (emoticonDiscounts[j] * 0.01));
                    }
                }
                
                if (sales >= users[i][1]) {
                    sales = 0;
                    plusCount++;
                }
                
                totalSales += sales;
            }
            
            if (map.get("plus") < plusCount) {
                map.put("plus", plusCount);
                map.put("sales", totalSales);
            } else if (map.get("plus") == plusCount) {
                if (map.get("sales") < totalSales) {
                    map.put("sales", totalSales);
                }
            }
            
            return;
        }
        
        for (int j = 10; j <= 40; j += 10) {
            emoticonDiscounts[currentDepth] = j;
            backTracking(currentDepth + 1, targetDepth);
        }
    }
}
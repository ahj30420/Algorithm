import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int result = 0;
        int maxDiff = 0;
        for (int diff : diffs) {
            maxDiff = Math.max(maxDiff, diff);
        }
        
        int left = 1;
        int right = maxDiff;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if (canClearPuzzle(diffs, times, limit, mid)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean canClearPuzzle(int[] diffs, int[] times, long limit, int level) {
        long clearTime = 0;
        for (int i = 0; i < diffs.length; i++) { 
            int currentDiff = diffs[i];
            int currentTime = times[i];
            int preTime = i == 0 ? 0 : times[i-1];
            if (currentDiff <= level) {
                clearTime += currentTime;
            } else {
                int diffCount = currentDiff - level;
                clearTime += diffCount * (currentTime + preTime) + currentTime;
            }
        }
        return clearTime <= limit;
    }
}
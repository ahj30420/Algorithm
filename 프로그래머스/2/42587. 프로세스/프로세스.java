import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            queue.add(i);
        }
        
        int maxValue = calculateMaxValue(priorities);
        int result = 0;
        
        while (priorities[location] != -1) {
            int target = queue.poll();
            
            if (priorities[target] == maxValue) {
                result++;
                priorities[target] = -1;
                maxValue = calculateMaxValue(priorities);
                continue;
            }
            
            queue.add(target);
        }
        
        return result;
    }
    
    private int calculateMaxValue(int[] priorities) {
        int max = 0;
        for (int priority : priorities) {
            if (max < priority) {
                max = priority;
            }
        }
        return max;
    }
}
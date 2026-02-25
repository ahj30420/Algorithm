import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add(days);
        }
        
        List<Integer> list = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int deployDay = queue.poll();
            int count = 1;
            
            while (!queue.isEmpty() && queue.peek() <= deployDay) {
                queue.poll();
                count++;
            }
            
            list.add(count);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
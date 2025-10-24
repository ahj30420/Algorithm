import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        PriorityQueue<Stage> pq = new PriorityQueue<>();
        
        for (int i = 1; i <= N; i++) {
            int challengers = 0;
            int unclearedCount = 0;
            for (int stage : stages) {
                if (i <= stage) challengers++;
                if (i == stage) unclearedCount++;
            }
            pq.add(new Stage(i, challengers, unclearedCount));
        }
        
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll().getStageNumber());
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private class Stage implements Comparable<Stage> {
        private int stageNumber;
        private int challengers;
        private int unclearedCount;
        
        public Stage(int stageNumber, int challengers, int unclearedCount) {
            this.stageNumber = stageNumber;
            this.challengers = challengers;
            this.unclearedCount = unclearedCount;
        }
        
        public int getStageNumber() { return this.stageNumber; }
        
        private double calculateFailureRate() {
            return (double) (double) unclearedCount / challengers;
        }
        
        public int compareTo(Stage other) {
            double diff = other.calculateFailureRate() - this.calculateFailureRate();
            if (diff > 0) return 1;
            if (diff < 0) return -1;
            return this.stageNumber - other.stageNumber;
        }
    }
}
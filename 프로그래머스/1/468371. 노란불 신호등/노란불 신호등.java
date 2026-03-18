import java.util.*;

class Solution {
    
    static class Signal {
        int index;
        int color;
        int seconds;
        
        Signal (int index, int color, int seconds) {
            this.index = index;
            this.color = color;
            this.seconds = seconds;
        }
        
        void next(int[] signal) {
            int limit = signal[color];
            
            if (seconds + 1 > limit) {
                color = (color + 1) % 3;
                seconds = 1;
            } else {
                seconds++;
            }
        }
    }
    
    public int solution(int[][] signals) {
        List<Signal> signalList = new ArrayList<>();
        for (int i = 0; i < signals.length; i++) {
            signalList.add(new Signal(i, 0, 0));
        }
        
        int maxValue = 1;
        for (int[] signal : signals) {
            int sum = signal[0] + signal[1] + signal[2];
            maxValue *= sum;
        }
        
        int answer = 1;
        while (answer <= maxValue) {           
            for (Signal s : signalList) {
                s.next(signals[s.index]);
            }
            
            boolean isCeasefire = true;
            for (Signal s : signalList) {
                if (s.color != 1) isCeasefire = false;
            }
            
            if (isCeasefire) return answer;
            
            answer++;
        }
        
        return -1;
    }
}
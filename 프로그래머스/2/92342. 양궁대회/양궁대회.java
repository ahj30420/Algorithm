class Solution {
    
    private int[] answer = new int[11];
    private int[] ryanScore = new int[11];
    private int[] apeachScore;
    private boolean canWin = false;
    private int diffScore = 0;
    
    public int[] solution(int n, int[] info) {
        this.apeachScore = info;
        backTracking(n,0);
        return canWin ? answer : new int[] {-1};
    }
    
    private void backTracking(int remainingArrows, int depth) {
        if (depth == 11) { 
            int apeach = 0;
            int ryon = 0;
            for (int i = 0; i < 11; i++) {
                if (ryanScore[i] > apeachScore[i]) {
                    ryon += 10 - i;
                } else if (apeachScore[i] > 0) {
                    apeach += 10 - i;
                }
            }
            
            int diff = ryon - apeach;
            if (diff > 0) {
                if (diff > diffScore) {
                    diffScore = diff;
                    answer = ryanScore.clone();
                    canWin = true;
                } else if (diff == diffScore) {
                    for (int i = 10; i >= 0; i--) {
                        if (ryanScore[i] > answer[i]){
                            answer = ryanScore.clone();
                            break;
                        } else if (ryanScore[i] < answer[i]) {
                            break;
                        }
                    }
                }
            }
        
            return;
        }
        
        for (int i = remainingArrows; i >= 0; i--) {
            ryanScore[depth] = i;
            backTracking(remainingArrows - i, depth + 1);
        }
    }
} 
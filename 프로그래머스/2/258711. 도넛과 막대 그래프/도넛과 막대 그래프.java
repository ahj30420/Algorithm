class Solution {
    public int[] solution(int[][] edges) {
        int edgeCount = 0;
        for (int[] edge : edges) {
            edgeCount = Math.max(edgeCount, Math.max(edge[0], edge[1]));
        }
        
        int[] in = new int[edgeCount + 1];
        int[] out = new int[edgeCount + 1];
        
        for (int[] edge : edges) {
            out[edge[0]]++;
            in[edge[1]]++;
        } 
        
        int created = 0;
        int dnout = 0;
        int bar = 0;
        int eight = 0;
        
        for (int i = 1; i <= edgeCount; i++) {
            if (in[i] == 0 && out[i] >= 2) {
                created = i;
            } else if (in[i] >= 1 && out[i] == 0) {
                bar++;
            } else if (in[i] >= 2 && out[i] == 2) {
                eight++;
            }
        }
        
        dnout = out[created] - (bar + eight);
        
        return new int[] {created, dnout, bar, eight};
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            answer[i] = func(array, commands[i]);
        }
        return answer;
    }
    
    private int func(int[] array, int[] command) {
        int i = command[0] - 1;
        int j = command[1] - 1;
        int k = command[2] - 1;
        
        List<Integer> list = new ArrayList<>();
        
        for (int n = i; n <= j; n++) {
            list.add(array[n]);
        }
        
        Collections.sort(list);
        
        return list.get(k);
    }
}
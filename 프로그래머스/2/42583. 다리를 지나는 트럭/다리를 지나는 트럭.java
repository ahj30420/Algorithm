import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < bridge_length-1; i++) {
            queue.add(0);
        }
        
        queue.add(truck_weights[0]);
        
        int answer = 1;
        int currentBridgeWeight = truck_weights[0];
        int truckIndex = 1;
        
        while (currentBridgeWeight > 0) {
            int arrivedTruckWeight = queue.poll();
            currentBridgeWeight -= arrivedTruckWeight;
            
            int newDepartingTruckWeight = 0;
            if (truckIndex < truck_weights.length 
                && currentBridgeWeight + truck_weights[truckIndex] <= weight) {
                newDepartingTruckWeight = truck_weights[truckIndex];
                truckIndex++;
            }
            
            queue.add(newDepartingTruckWeight);
            currentBridgeWeight += newDepartingTruckWeight;
            answer++;
        }
        
        return answer;
    }
}
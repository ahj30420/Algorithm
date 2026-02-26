import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}
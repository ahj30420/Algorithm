import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
         
        StringBuilder sb = new StringBuilder();
        for(String s : nums) {
            sb.append(s);
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
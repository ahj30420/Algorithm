class Solution {
    public int solution(String s) {
        int result = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0,i);
            int count = 1;
            
            for (int j = i; j < s.length(); j += i) {
                int end = Math.min(j + i, s.length());
                String current = s.substring(j, end);
                
                if (prev.equals(current)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    prev = current;
                    count = 1;
                }
            }
            
            if (count > 1) sb.append(count);
            sb.append(prev);
            
            result = Math.min(result, sb.length());
        }
        
        return result;
    }
}
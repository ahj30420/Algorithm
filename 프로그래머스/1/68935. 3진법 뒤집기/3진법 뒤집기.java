class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n >= 3) {
            sb.append(n % 3);
            n = n / 3;
        }
        sb.append(n);
        
        String s = sb.toString();
        
        int base = 1;
        int answer = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int target = s.charAt(i) - '0';
            answer += target * base;
            base *= 3;
        }
        
        return answer;
    }
}
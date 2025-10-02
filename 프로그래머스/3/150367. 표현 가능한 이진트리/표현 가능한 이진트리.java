class Solution {
    
    private boolean isSaturatedBinarTree;
    
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            isSaturatedBinarTree = true;
            String binaryNumber = changeBinary(numbers[i]);
            checkSaturatedBinarTree(binaryNumber, 0, binaryNumber.length()-1);
            answer[i] = isSaturatedBinarTree ? 1 : 0;
        }
        
        return answer;
    }
    
    private String changeBinary(long number) {
        StringBuilder sb = new StringBuilder();  
        
        while(number > 1) {
            sb.append(number % 2);
            number /= 2;
        }  
        sb.append(number);
        
        String binaryNumber = sb.reverse().toString();
        
        int len = binaryNumber.length();
        int h = 1;
        while((int)Math.pow(2,h) - 1 < len) h++;
        int fullLen = (int)Math.pow(2,h) - 1;
        
        StringBuilder padded = new StringBuilder();
        for (int i = 0; i < fullLen - len; i++) {
            padded.append('0');
        }
        padded.append(binaryNumber);
        
        return padded.toString();
    }
    
    private void checkSaturatedBinarTree(String binaryNumber, int left, int right) {
        if (left > right) { return; }
        
        int mid = (left + right) / 2;
        
        if (binaryNumber.charAt(mid) == '0') { 
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += binaryNumber.charAt(i) - '0';
            }
            
            if (sum != 0) {
                isSaturatedBinarTree = false;
                return;
            }
        }
        
        checkSaturatedBinarTree(binaryNumber, left, mid - 1);
        checkSaturatedBinarTree(binaryNumber, mid + 1, right);
    }
}
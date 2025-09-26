class Solution {
    public String solution(String new_id) {
        String recommendId = "";
        
        recommendId = step1(new_id);
        recommendId = step2(recommendId);
        recommendId = step3(recommendId);
        recommendId = step4(recommendId);
        recommendId = step5(recommendId);
        recommendId = step6(recommendId);
        recommendId = step7(recommendId);
        
        System.out.println(recommendId);
        
        return recommendId;
    }
    
    private String step1(String newId) {
        return newId.toLowerCase();
    }
    
    private String step2(String newId) {
        String result = "";
        
        for (int i = 0; i < newId.length(); i++) {
            char c = newId.charAt(i);
            
            if (c == '-' || c == '_' || c == '.' || Character.isDigit(c) || Character.isLowerCase(c)) {
                result += c;
            }
        }
        
        return result;
    }
    
    private String step3(String newId) {
        int dotCount = newId.length();
        String result = newId;
        
        while(dotCount > 1) {
            String dots = ".".repeat(dotCount);
            newId = newId.replace(dots,".");
            dotCount--;
        }
        
        return newId;
    }
    
    private String step4(String newId) {
        if (newId.isEmpty()) {
            return newId;
        }
    
        if (newId.charAt(0) == '.') {
            newId = newId.substring(1);
            if (newId.isEmpty()) return newId;
        }

        if (!newId.isEmpty() && newId.charAt(newId.length() - 1) == '.') {
            newId = newId.substring(0, newId.length() - 1);
        }

        return newId;
    }
    
    private String step5(String newId) {
        if (newId.isEmpty()) {
            newId = "a";
        }
        return newId;
    }
    
    private String step6(String newId) {
        if (newId.length() >= 16) {
            newId = newId.substring(0,15);
            if (newId.charAt(14) == '.') {
                newId = newId.substring(0,14);
            }
        }
        return newId;
    }
    
    private String step7(String newId) {
        if (newId.length() <= 2) {
            while(newId.length() < 3) {
                char plusChar = newId.charAt(newId.length() - 1);
                newId += plusChar;
            }
        }
        return newId;
    }
}
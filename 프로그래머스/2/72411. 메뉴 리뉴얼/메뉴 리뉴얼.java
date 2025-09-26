import java.util.*;

class Solution {
    private String[] orderList;
    private Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        orderList = orders;
        
        for (int c : course) {
            for (String order : orders) {
                String[] str = new String[c];
                backTracking(ArrayString(order), c, str, 0, 0);
            }
        }
        
        List<String> result = new ArrayList<>();
        Set<String> menuCombination = map.keySet();
        for (int c : course) {
            int maxCount = 0;
            for (String menu : menuCombination) {
                if (menu.length() == c) {
                    maxCount = Math.max(maxCount, map.get(menu));
                }
            }

            for (String menu : menuCombination) {
                if (menu.length() == c && map.get(menu) == maxCount) {
                    result.add(menu);
                }
            }
        }
        
        Collections.sort(result);
        
        return result.toArray(new String[0]);
    }
    
    private String ArrayString(String order) {
        char[] chars = order.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    private void backTracking(String order, int course, String[] str, int preIndex, int currentDepth) {
        if (currentDepth == course) {
            
            String combination = String.join("", str);
            int count = 0;
            for (String targetOrder : orderList) {
                boolean hasAll = true;
                for (String s : str) {
                    if (!targetOrder.contains(s)) {
                        hasAll = false;
                        break;
                    }
                }    
                if (hasAll) count++;
            }
            
            if (count >= 2) {
                map.put(combination, count);
            }
            return;
        }
        
        for (int i = preIndex; i < order.length(); i++) {
            str[currentDepth] = Character.toString(order.charAt(i));
            backTracking(order, course, str, i+1, currentDepth+1);
        }
    }
}
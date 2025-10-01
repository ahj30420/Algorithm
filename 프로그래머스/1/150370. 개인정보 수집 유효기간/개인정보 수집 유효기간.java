import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] t = term.split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }
        
        int changedToday = changeDay(today);
        List<Integer> list = new ArrayList<>();    
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");    
            int changedDay = changeDay(privacy[0]);
            int expirationDate = plusTerms(changedDay, map.get(privacy[1]));
            
            if (changedToday >= expirationDate) {
                list.add(i+1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int changeDay(String date) {
        String[] d = date.split("\\.");
        int year = Integer.parseInt(d[0]);
        int month = Integer.parseInt(d[1]);
        int day = Integer.parseInt(d[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
    
    private int plusTerms(int day, int month) {
        return day + (month * 28);
    }
    
}
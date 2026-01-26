import java.util.*;

class Solution {

    Map<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        for (int len : course) {
            for (String order : orders) {
                backTracking(order, "", 0, 0, len);
            }
        }

        List<String> result = new ArrayList<>();

        for (int len : course) {
            int max = 2;

            for (String key : map.keySet()) {
                if (key.length() == len) {
                    max = Math.max(max, map.get(key));
                }
            }

            for (String key : map.keySet()) {
                if (key.length() == len && map.get(key) == max) {
                    result.add(key);
                }
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    private void backTracking(String order, String comb, int idx, int depth, int target) {
        if (depth == target) {
            map.put(comb, map.getOrDefault(comb, 0) + 1);
            return;
        }

        for (int i = idx; i < order.length(); i++) {
            backTracking(order, comb + order.charAt(i), i + 1, depth + 1, target);
        }
    }
}

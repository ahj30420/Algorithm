package algorithm.backTracking;

import java.util.*;
import java.io.*;

// 줄어드는 수
public class DecreasingNumber {

    static boolean[] visited = new boolean[10];
    static List<Long> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        for(long i = 0; i <= 9; i++) {
            result.add(i);
            backTracking(i, i);
        }

        Collections.sort(result);

        if(N <= result.size()) {
            System.out.println(result.get(N - 1));
        } else {
            System.out.println(-1);
        }

        reader.close();
    }

    private static void backTracking(long resultNumber, long preNumber) {
        for(int i = 0; i <= 9; i++){
            if(!visited[i] && i < preNumber) {
                visited[i] = true;
                result.add(resultNumber * 10 + i);
                backTracking(resultNumber * 10 + i, i);
                visited[i] = false;
            }
        }
    }
}

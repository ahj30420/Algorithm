package algorithm.binarysearch;

import java.util.*;
import java.io.*;

//공유기 설치
public class InstallRouter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        int[] houses = new int[N];
        for(int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(houses);

        int left = 1;
        int right = houses[N-1] - houses[0];
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(canInstall(mid, houses, C)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
        reader.close();
    }

    private static boolean canInstall(int minGap, int[] houses, int c) {
        int count = 1;
        int lastInstalled = houses[0];

        for(int i = 1; i < houses.length; i++) {
            if(houses[i] - lastInstalled >= minGap) {
                count++;
                lastInstalled = houses[i];
            }
        }
        return count >= c;
    }
}

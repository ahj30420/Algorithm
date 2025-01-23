package algorithm.binarysearch;

import java.util.*;
import java.io.*;

// 휴게소 세우기
public class EstablishingRestArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int L = Integer.parseInt(tokenizer.nextToken());

        int[] restAreas = new int[N + 2];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 1; i <= N; i++) {
            restAreas[i] = Integer.parseInt(tokenizer.nextToken());
        }

        restAreas[0] = 0;
        restAreas[N + 1] = L;

        Arrays.sort(restAreas);

        int left = 1;
        int right = L;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(canInstall(mid, restAreas, M)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
        reader.close();
    }

    private static boolean canInstall(int maxGap, int[] restAreas, int M) {
        int count = 0;
        for(int i = 1; i < restAreas.length; i++) {
            int gap = restAreas[i] - restAreas[i - 1];
            if(gap > maxGap) {
                count += (gap - 1) / maxGap;
            }
        }
        return count <= M;
    }
}

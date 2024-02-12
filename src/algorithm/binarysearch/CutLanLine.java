package algorithm.binarysearch;

import java.util.*;
import java.io.*;

public class CutLanLine {

    private static int[] lanLine;
    private static int k, n;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        lanLine = new int[k];

        int maxLine = 0;
        for (int i = 0; i < k; i++) {
            lanLine[i] = Integer.parseInt(reader.readLine());
            maxLine = Math.max(maxLine, lanLine[i]);
        }

        System.out.println(binarySearch(1, maxLine));
        reader.close();
    }

    private static int binarySearch(long start, long end) {
        int result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (int i = 0; i < k; i++) {
                count += lanLine[i] / mid;
            }

            if (count < n) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = (int)mid;
            }
        }

        return result;
    }

}
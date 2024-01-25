package algorithm.binarysearch;

import java.io.*;
import java.util.*;

//기타 레슨
public class OtherLectures {

    public static int[] arr;
    public static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        int maxSize = 0;
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxSize = Math.max(maxSize, arr[i]);
        }

        int result = binarySearch(maxSize, maxSize * n);

        System.out.println(result);
        reader.close();
    }

    private static int binarySearch(int start, int end) {
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static boolean isPossible(int max) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > max) {
                count++;
                sum = 0;
            }
            sum += arr[i];
        }

        return count <= m;
    }
}

package algorithm.binarysearch;

import java.util.*;
import java.io.*;

// 입국심사
public class EntryScreening {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        long[] times = new long[N];
        long maxTime = 0;
        for(int i = 0; i < N; i++) {
            times[i] = Long.parseLong(reader.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        long left = 1;
        long right = maxTime * M;
        long result = right;

        while(left <= right) {
            long mid = (left + right) / 2;
            long people = 0;

            for(long time : times) {
                people += mid / time;

                 if (people >= M) {
                    break;
                }
            }

            if(people >= M) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
        reader.close();
    }
}

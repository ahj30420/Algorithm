package algorithm.backTracking;

import java.util.*;
import java.io.*;

// N과 M (1)
public class N_M_1 {

    private static int N, M;
    private static int[] selected;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        selected = new int[M];
        visited = new boolean[N+1];

        backTracking(0);
        System.out.println(sb.toString());
    }

    private static void backTracking(int depth){
        if(depth == M){
            for(int i = 0; i < M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}

package algorithm.BFS;

import java.util.*;
import java.io.*;

//스타트 링크
public class StartLink {

    private static int[] floor;
    private static int F, S, G;
    private static int[] nextMove = new int[2];

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) -1;
        G = Integer.parseInt(st.nextToken()) -1;
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        floor = new int[F];
        Arrays.fill(floor, -1);

        nextMove[0] = U;
        nextMove[1] = -D;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        floor[S] = 0;

        while(!queue.isEmpty()){
            int nowF = queue.poll();

            if(nowF == G){
                System.out.println(floor[nowF]);
                return;
            }

            for(int i = 0; i < 2; i++){
                int cd = nowF + nextMove[i];

                if(cd >= 0 && cd < F && floor[cd] == -1){
                    queue.add(cd);
                    floor[cd] = floor[nowF] + 1;
                }
            }

        }

        System.out.println("use the stairs");
        reader.close();
    }
}

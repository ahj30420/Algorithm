package algorithm.BFS;

import java.io.*;
import java.util.*;

//나이트의 이동
public class NightMove {

    private static int[][] map;
    private static int testcase;
    private static int len;
    private static Location start,end;
    private static int[] nextY = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] nextX = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        testcase = Integer.parseInt(reader.readLine());

        for(int i = 0; i < testcase; i++){
            len = Integer.parseInt(reader.readLine());
            map = new int[len][len];

            StringTokenizer st = new StringTokenizer(reader.readLine());

            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            start = new Location(startY, startX);

            st = new StringTokenizer(reader.readLine());

            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            end = new Location(endY, endX);

            sb.append(bfs()).append("\n");
        }

        System.out.println(sb.toString());
        reader.close();
    }

    private static int bfs(){
        Queue<Location> queue = new LinkedList<>();
        queue.add(start);

        int targetY = end.getY();
        int targetX = end.getX();

        while(!queue.isEmpty()){
            Location nowLoc = queue.poll();
            int nowY = nowLoc.getY();
            int nowX = nowLoc.getX();

            if(nowY == targetY && nowX == targetX){
                return map[nowY][nowX];
            }

            for(int i = 0; i < 8; i++){
                int cy = nowY + nextY[i];
                int cx = nowX + nextX[i];

                if(cy >= 0 && cy < len && cx >= 0 && cx < len && map[cy][cx] == 0){
                    Location nextLoc = new Location(cy,cx);
                    queue.add(nextLoc);
                    map[cy][cx] = map[nowY][nowX] + 1;
                }
            }
        }

        return 0;
    }

    private static class Location{
        private int y;
        private int x;

        public Location(int y, int x){
            this.y = y;
            this.x = x;
        }

        public int getY(){
            return y;
        }

        public int getX(){
            return x;
        }
    }

}

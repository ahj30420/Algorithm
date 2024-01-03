package algorithm.BFS;

import java.io.*;
import java.util.*;

//미로 탈출
public class EscapeMaze {

    public static int n,m;
    public static int[][] map = new int[201][201];

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        for(int i = 0; i < n; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            String target = tokenizer.nextToken();
            for(int j = 0; j < m; j++){
                map[i][j] = target.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
        reader.close();
    }

    private static int bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(map[nx][ny] == 0) continue;

                if(map[nx][ny] == 1){
                    map[nx][ny] = map[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return map[n-1][m-1];
    }
}


class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

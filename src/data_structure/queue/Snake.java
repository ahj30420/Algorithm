package data_structure.queue;

import java.util.*;
import java.io.*;

//뱀
public class Snake {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0; i < k; i++){
            SettingApples(reader, arr);
        }

        int l = Integer.parseInt(reader.readLine());
        Map<Integer, Character> map = new HashMap<>();

        for(int i = 0; i < l; i++){
            SettingDirectionChange(reader, map);
        }

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};
        int dir = 0;
        int sec = 0;
        int x = 0;
        int y = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0,0});

        while(true){
            sec++;

            x += dx[dir];
            y += dy[dir];

            if(x < 0 || x >= n || y < 0 || y >= n || arr[y][x] == 2){
                break;
            }

            if(arr[y][x] != 1){
                int[] tail = deque.pollLast();
                arr[tail[0]][tail[1]] = 0;
            }

            deque.offerFirst(new int[]{y,x});
            arr[y][x] = 2;

            if(map.containsKey(sec)){
                char c = map.get(sec);
                if(c == 'L'){
                    dir = (dir + 3) % 4;
                } else if (c == 'D'){
                    dir = (dir + 1) % 4;
                }
            }
        }

        System.out.println(sec);
        reader.close();
    }

    private static void SettingApples(BufferedReader reader, int[][] arr) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(tokenizer.nextToken()) - 1;
        int x = Integer.parseInt(tokenizer.nextToken()) - 1;
        arr[y][x] = 1;
    }

    private static void SettingDirectionChange(BufferedReader reader, Map<Integer, Character> map) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int sec = Integer.parseInt(tokenizer.nextToken());
        char dir = tokenizer.nextToken().charAt(0);
        map.put(sec,dir);
    }

}

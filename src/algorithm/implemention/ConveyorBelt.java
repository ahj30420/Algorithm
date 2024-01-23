package algorithm.implemention;

import java.io.*;
import java.util.*;

//컨베이어 벨트 위의 로봇
public class ConveyorBelt {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int[] belt = new int[2*n];
        boolean[] robot = new boolean[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < 2*n; i++){
            belt[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int result = 0;

        while(true){
            result++;

            int temp = belt[n*2-1];
            for(int i = n*2-1; i > 0; i--){
                belt[i] = belt[i-1];
            }
            belt[0] = temp;

            for(int i = n-1; i > 0; i--){
                robot[i] = robot[i-1];
            }
            robot[n-1] = false;
            robot[0] = false;

            for(int i = n-1; i > 0; i--){
                if(robot[i-1] && !robot[i] && belt[i] > 0){
                    robot[i] = true;
                    robot[i-1] = false;
                    belt[i]--;
                    robot[n-1] = false;
                }
            }

            if(belt[0] > 0){
                robot[0] = true;
                belt[0]--;
            }

            int count = 0;
            for(int i = 0; i < n*2; i++){
                if(belt[i] == 0) count++;
            }
            if(count >= k) break;
        }

        System.out.println(result);
        reader.close();
    }
}

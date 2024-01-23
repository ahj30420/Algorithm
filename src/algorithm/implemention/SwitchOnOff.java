package algorithm.implemention;

import java.util.*;
import java.io.*;

//스위치 켜고 끄기
public class SwitchOnOff {

    public static int[] state;

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        state = new int[n+1];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 1; i <= n; i++){
            state[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int sn = Integer.parseInt(reader.readLine());

        for(int i = 0; i < sn; i++){
            tokenizer = new StringTokenizer(reader.readLine());
            int[] s = new int[2];
            s[0] = Integer.parseInt(tokenizer.nextToken());
            s[1] = Integer.parseInt(tokenizer.nextToken());

            if(s[0] == 1){
                int num = s[1];

                while(num <= n){
                    change(num);
                    num += s[1];
                }
            } else{
                int left = s[1] - 1;
                int right = s[1] + 1;

                change(s[1]);
                while(left >= 1 && right <= n){
                    if(state[left] == state[right]){
                        change(left);
                        change(right);

                        left -= 1;
                        right += 1;
                    } else{
                        break;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            System.out.print(state[i] + " ");
            if(i % 20 == 0){
                System.out.println();
            }
        }

        reader.close();
    }

    private static void change(int i) {
        if(state[i] == 0) { state[i] = 1; }
        else{ state[i] = 0; }
    }
}

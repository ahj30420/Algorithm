package algorithm.greedy;

import java.util.*;
import java.io.*;

//A->B
public class AToB {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;

        while(b > a){
            String target = b + "";

            if(target.charAt(target.length()-1) == '1'){
                b = b / 10;
            } else{
                if(b % 2 == 0) {
                    b = b / 2;
                } else{
                    System.out.println(-1);
                    return;
                }
            }
            count++;
        }

        if(b == a){
            System.out.println(count+1);
        } else{
            System.out.println(-1);
        }
        reader.close();
    }
}

package algorithm.dynamic;

import java.io.*;

//1로 만들기
public class MakeOne {

    public static int[] d = new int[3001];

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());

        d[1] = 0;

        for(int i = 2; i <= x; i++){
            d[i] = d[i-1] + 1;
            if(i % 2 == 0) {
                d[i] = Math.min(d[i], d[i/2] + 1);
            }
            if(i % 3 == 0){
                d[i] = Math.min(d[i], d[i/3] + 1);
            }
            if(i % 5 == 0){
                d[i] = Math.min(d[i], d[i/5] + 1);
            }
        }

        System.out.println(d[x]);
        reader.close();
    }
}

package algorithm.implemention;

import java.util.*;
import java.io.*;

//왕실의 나이트
public class RoyalNight {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String input = scan.next();
        int col = input.charAt(0) - 'a' + 1;
        int row = input.charAt(1) - '0';

        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

        int count = 0;
        for(int i = 0; i < 8; i++){
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];

            if(nextRow >= 1 && nextRow <= 8 && nextCol >=1 && nextCol <= 8){
                count += 1;
            }
        }
        System.out.println(count);
    }
}

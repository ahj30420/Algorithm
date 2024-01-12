package algorithm.implemention;

import java.util.*;
import java.io.*;

//왕실의 나이트
public class RoyalNight {
    public static void main(String[] args){

       Scanner scan = new Scanner(System.in);

       String n = scan.next();

       int x = n.charAt(0) - 'a' + 1;
       int y = n.charAt(1) - '0';

       int[] dx = {1,2,2,1,-1,-2,-2,-1};
       int[] dy = {2,1,-1,-2,-2,-1,1,2};

       int count = 0;
       for(int i = 0; i < 8; i++){
           int cx = x + dx[i];
           int cy = y + dy[i];

           if(cx >= 1 && cx <= 8 && cy >= 1 && cy <= 8){
               count++;
           }
       }

        System.out.println(count);
    }
}

package algorithm.greedy;

import java.util.*;

//거스름 돈
public class Ghange {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] change = { 500, 100, 50, 10 };

        int count = 0;

        for(int i = 0; i < change.length; i++){
            count += n / change[i];
            n = n % change[i];
        }

        System.out.println(count);

    }
}

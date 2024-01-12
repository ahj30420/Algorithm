package algorithm.greedy;

import java.util.*;

//1이 될 때까지
public class Untils_1 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int count = 0;
        while(n != 1){
            if(n % k == 0){
                n = n/k;
            } else{
                n -= 1;
            }
            count++;
        }

        System.out.println(count);

    }
}

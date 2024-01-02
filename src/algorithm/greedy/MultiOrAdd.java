package algorithm.greedy;

import java.util.*;

//곱하기 혹은 더하기
public class MultiOrAdd {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String n = scan.next();
        long result = n.charAt(0) - '0';

        for(int i = 1; i < n.length(); i++){
            int elem = n.charAt(i) - '0';
            if(elem <= 1 || result <= 1){
                result += elem;
            } else{
                result *= elem;
            }
        }

        System.out.println(result);

    }
}

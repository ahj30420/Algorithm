package algorithm.greedy;

import java.util.*;

//곱하기 혹은 더하기
public class MultiOrAdd {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String n = scan.next();
        int result = n.charAt(0) - '0';
        for(int i = 1; i < n.length(); i++){
            int target = n.charAt(i) - '0';
            if(result <= 1 || target <=1){
                result += target;
            } else{
                result *= target;
            }
        }

        System.out.println(result);

    }
}

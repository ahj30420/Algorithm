package algorithm.implemention;

import java.io.*;
import java.util.*;

//문자열 재정렬
public class StringRealignment {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String n = scan.next();
        ArrayList<Character> result = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i < n.length(); i++){
            if(Character.isLetter(n.charAt(i))){
                result.add(n.charAt(i));
            } else{
                sum += n.charAt(i) - '0';
            }
        }

        Collections.sort(result);

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        if(sum != 0){
            System.out.println(sum);
        }

    }
}

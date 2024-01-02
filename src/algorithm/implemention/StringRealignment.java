package algorithm.implemention;

import java.io.*;
import java.util.*;

//문자열 재정렬
public class StringRealignment {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        ArrayList<Character> result = new ArrayList<>();

        int val = 0;
        for(int i = 0; i < input.length(); i++){
            if(Character.isLetter(input.charAt(i))){
                result.add(input.charAt(i));
            } else{
                val += input.charAt(i) - '0';
            }
        }

        Collections.sort(result);

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        if(val != 0){
            System.out.println(val);
        }
    }
}

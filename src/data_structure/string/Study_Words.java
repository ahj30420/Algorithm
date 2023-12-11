package data_structure.string;

import java.util.*;

//단어 공부
public class Study_Words {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String content = scan.next().toUpperCase();
        int[] arr = new int[26];

        for(int i = 0; i < content.length(); i++){
            int target = content.charAt(i) - 'A';
            arr[target]++;
        }

        int max = 0;
        char result = '?';

        for(int i = 0; i < 26; i++){
            if(arr[i] > max){
                max = arr[i];
                result = (char)(i + 'A');
            } else if(arr[i] == max){
                result = '?';
            }
        }
        System.out.println(result);
    }
}

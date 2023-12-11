package data_structure.string;

import java.io.*;
import java.util.*;

//알파벳 찾기
public class Find_Alphabet {
    public static void main(String[] args) throws IOException{

        Scanner scan = new Scanner(System.in);
        int[] arr = new int[26];

        String content = scan.next();

        Arrays.fill(arr, -1);

        for(int i = 0; i < content.length(); i++){
            int ind = (int) content.charAt(i) - 97;
            if(arr[ind] == -1){
                arr[ind] = i;
            }
        }

        for(int i = 0; i < 26; i++){
            System.out.print(arr[i]+" ");
        }

    }
}
